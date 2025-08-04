import java.util.*;

public class HeartbeatManager {
    private List<SimProcess> processes = new ArrayList<>();
    private SimulationClock clock;

    public HeartbeatManager(SimulationClock clock) { this.clock = clock; }

    public void registerProcess(SimProcess p) { processes.add(p); }

    public void run(int maxTicks) {
        for (int t = 0; t < maxTicks; t++) { stepOnce(); }
    }

    public void stepOnce() {
        boolean stable;
        do {
            stable = true;
            for (SimProcess p : processes) if (p.evaluate()) stable = false;
        } while (!stable);
        for (SimProcess p : processes) p.commit();
    }

    public SimulationClock getClock() { return clock; }
}
