import java.util.*;

public class WaveformViewer {
    private HeartbeatManager hb;
    private List<SimProcess> processes;

    public WaveformViewer(HeartbeatManager hb, List<SimProcess> processes) {
        this.hb = hb;
        this.processes = processes;
    }

    public void runDebug(int ticks) {
        for (int t = 0; t < ticks; t++) {
            hb.stepOnce();
            System.out.print("Time " + hb.getClock().getCurrentTime() + ": ");
            for (SimProcess p : processes) {
                String[][] state = p.getState();
                System.out.print("[" + p.getClass().getSimpleName() + ": ");
                for (String[] s : state) System.out.print(s[0] + "=" + s[1] + " ");
                System.out.print("] ");
            }
            System.out.println();
        }
    }
}
