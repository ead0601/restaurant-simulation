import java.util.*;
import java.lang.reflect.*;
import java.io.*;

public class HeartbeatManager {
    private List<SimProcess> processes = new ArrayList<>();
    private SimulationClock clock;
    private PrintWriter vcdWriter;
    private Map<String, String> signalIds = new HashMap<>();
    private int signalCounter = 0;

    public HeartbeatManager(SimulationClock clock) {
        this.clock = clock;
    }

    public void registerProcess(SimProcess p) { processes.add(p); }
    public SimulationClock getClock() { return clock; }
    public List<SimProcess> getProcesses() { return processes; }

    public void run(int maxTicks) {
        for (int t = 0; t < maxTicks; t++) stepOnce();
    }

    public void stepOnce() {
        boolean stable;
        do {
            stable = true;
            for (SimProcess p : processes) if (p.evaluate()) stable = false;
        } while (!stable);
        for (SimProcess p : processes) p.commit();
    }

    // ===== Console Interface =====
    public void startConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simulation Kernel Console (with Waveform Logging). Type 'help' for commands.");
        while (true) {
            System.out.print("sim> ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");
            if (parts.length == 0 || parts[0].isEmpty()) continue;

            switch (parts[0].toLowerCase()) {
                case "help": printHelp(); break;
                case "list": listObjects(); break;
                case "show": if (parts.length > 1) showObject(parts[1]); else System.out.println("Usage: show <object>"); break;
                case "set": if (parts.length > 3) setValue(parts[1], parts[2], parts[3]); else System.out.println("Usage: set <obj> <field> <value>"); break;
                case "tick": tick(parts.length > 1 ? Integer.parseInt(parts[1]) : 1); break;
                case "run": if (parts.length > 1) runTicks(Integer.parseInt(parts[1])); else System.out.println("Usage: run <ticks>"); break;
                case "log": if (parts.length > 2 && parts[1].equalsIgnoreCase("start")) startLogging(parts[2]);
                            else if (parts.length > 1 && parts[1].equalsIgnoreCase("stop")) stopLogging();
                            else System.out.println("Usage: log start <filename> | log stop"); break;
                case "quit": case "exit": stopLogging(); System.out.println("Exiting console."); return;
                default: System.out.println("Unknown command. Type 'help' for commands.");
            }
        }
    }

    private void printHelp() {
        System.out.println("Commands:");
        System.out.println("  list                - List all simulation objects");
        System.out.println("  show <object>       - Show state of an object");
        System.out.println("  set <obj> <field> <value> - Modify a field value");
        System.out.println("  tick [N]            - Advance simulation by N ticks");
        System.out.println("  run <N>             - Run simulation for N ticks");
        System.out.println("  log start <file>    - Start VCD logging");
        System.out.println("  log stop            - Stop VCD logging");
        System.out.println("  quit/exit           - Exit console");
    }

    private void listObjects() {
        for (SimProcess p : processes) System.out.println(p.getClass().getSimpleName());
    }

    private void showObject(String objName) {
        for (SimProcess p : processes) {
            if (p.getClass().getSimpleName().equalsIgnoreCase(objName)) {
                System.out.println(objName + " state:");
                for (String[] s : p.getState()) System.out.println("  " + s[0] + " = " + s[1]);
                return;
            }
        }
        System.out.println("Object not found: " + objName);
    }

    private void setValue(String objName, String fieldName, String value) {
        for (SimProcess p : processes) {
            if (p.getClass().getSimpleName().equalsIgnoreCase(objName)) {
                try {
                    Field f = p.getClass().getDeclaredField(fieldName);
                    f.setAccessible(true);
                    f.set(p, parseValue(f.getType(), value));
                    System.out.println("Updated " + objName + "." + fieldName + " = " + value);
                } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
                return;
            }
        }
        System.out.println("Object not found: " + objName);
    }

    private Object parseValue(Class<?> type, String value) {
        if (type == int.class || type == Integer.class) return Integer.parseInt(value);
        if (type == double.class || type == Double.class) return Double.parseDouble(value);
        if (type == boolean.class || type == Boolean.class) return Boolean.parseBoolean(value);
        return value;
    }

    private void tick(int n) { for (int i = 0; i < n; i++) { stepOnce(); logTick(clock.getCurrentTime()); displayStates(); } }
    private void runTicks(int ticks) { for (int i = 0; i < ticks; i++) { stepOnce(); logTick(clock.getCurrentTime()); displayStates(); } }

    private void displayStates() {
        System.out.print("Time " + clock.getCurrentTime() + ": ");
        for (SimProcess p : processes) {
            System.out.print("[" + p.getClass().getSimpleName() + ": ");
            for (String[] s : p.getState()) System.out.print(s[0] + "=" + s[1] + " ");
            System.out.print("] ");
        }
        System.out.println();
    }

    // ===== Waveform Logging =====
    public void startLogging(String filename) {
        try {
            vcdWriter = new PrintWriter(new FileWriter(filename));
            vcdWriter.println("$date " + new Date() + " $end");
            vcdWriter.println("$version Simulation $end");
            vcdWriter.println("$timescale 1ns $end");
            vcdWriter.println("$scope module simulation $end");
            for (SimProcess p : processes) {
                for (String[] s : p.getState()) {
                    String id = "s" + (signalCounter++);
                    signalIds.put(p.getClass().getSimpleName() + "." + s[0], id);
                    vcdWriter.println("$var wire 32 " + id + " " + p.getClass().getSimpleName() + "_" + s[0] + " $end");
                }
            }
            vcdWriter.println("$upscope $end");
            vcdWriter.println("$enddefinitions $end");
            System.out.println("VCD logging started: " + filename);
        } catch (IOException e) { System.out.println("Error starting VCD logging: " + e.getMessage()); }
    }

    public void logTick(int tick) {
        if (vcdWriter != null) {
            vcdWriter.println("#" + tick);
            for (SimProcess p : processes) {
                for (String[] s : p.getState()) {
                    String key = p.getClass().getSimpleName() + "." + s[0];
                    try {
                        int val = Integer.parseInt(s[1]);
                        vcdWriter.println("b" + Integer.toBinaryString(val) + " " + signalIds.get(key));
                    } catch (NumberFormatException e) {
                        vcdWriter.println("b0 " + signalIds.get(key));
                    }
                }
            }
        }
    }

    public void stopLogging() {
        if (vcdWriter != null) { vcdWriter.close(); vcdWriter = null; System.out.println("VCD logging stopped."); }
    }
}
