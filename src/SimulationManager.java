import java.util.*;
import java.util.function.Supplier;


public class SimulationManager {
    private String initFileName;
    private SimulationClock clock = new SimulationClock();
    private Map<String, Map<String, Supplier<Object>>> objectLogRegistry = new HashMap<>();
    private java.io.PrintWriter logWriter;
    private String vcdFileName;

    public void startConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Simulation Console Started. Type 'help' for commands.");
        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("quit")) break;
            executeCommand(line);
        }
    }

    public void executeCommand(String cmd) {
        String[] parts = cmd.split(" ");
        switch(parts[0]) {
            case "help":
                System.out.println("Commands: run <ticks>, step, load <file>, reset, save <file>, listObjects, showObject <name>, setValue <obj> <var> <val>, startLogging, stopLogging, setVCD <file>");
                break;
            case "run": run(Integer.parseInt(parts[1])); break;
            case "step": stepOnce(); break;
            case "load": loadInitFile(parts[1]); break;
            case "reset": resetSimulation(); break;
            case "save": saveState(parts[1]); break;
            case "setVCD": setVCD(parts[1]); break;
            case "startLogging": startLogging(); break;
            case "stopLogging": stopLogging(); break;
            default: System.out.println("Unknown command: " + parts[0]);
        }
    }

    public void registerLoggables(String objectName, Map<String, Supplier<Object>> logMap) {
        objectLogRegistry.put(objectName, logMap);
    }

    public void logObject(String objectName) {
        if (!objectLogRegistry.containsKey(objectName)) return;
        Map<String, Supplier<Object>> vars = objectLogRegistry.get(objectName);
        StringBuilder logEntry = new StringBuilder("[" + clock.getTime() + "] " + objectName + ": ");
        for (Map.Entry<String, Supplier<Object>> entry : vars.entrySet()) {
            logEntry.append(entry.getKey()).append("=").append(entry.getValue().get()).append(", ");
        }
        if (logWriter != null) logWriter.println(logEntry.toString());
        System.out.println(logEntry);
    }

    public void triggerLog(String objectName) {
        logObject(objectName);
    }

    public void loadInitFile(String fileName) {
        this.initFileName = fileName;
        System.out.println("Loaded init file: " + fileName);
        // File parsing and object variable setting logic to be implemented
    }

    public void resetSimulation() {
        if (initFileName != null) loadInitFile(initFileName);
        clock.reset();
        System.out.println("Simulation reset.");
    }

    public void saveState(String fileName) {
        System.out.println("Saving state to " + fileName);
        // Iterate objects and dump current state
    }

    public void setVCD(String filename) {
        this.vcdFileName = filename;
        try {
            this.logWriter = new java.io.PrintWriter(filename);
            System.out.println("Logging to " + filename);
        } catch (Exception e) {
            System.out.println("Failed to open log file: " + e.getMessage());
        }
    }

    public void startLogging() { System.out.println("Logging started."); }
    public void stopLogging() { System.out.println("Logging stopped."); if (logWriter != null) logWriter.close(); }

    public void run(int ticks) {
        System.out.println("Running " + ticks + " ticks.");
        for (int i = 0; i < ticks; i++) {
            clock.advanceTime();
        }
    }

    public void stepOnce() {
        clock.advanceTime();
        System.out.println("Stepped one tick to time " + clock.getTime());
    }

    public SimulationClock getClock() { return clock; }
}
