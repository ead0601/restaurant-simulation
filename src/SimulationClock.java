import java.util.*;
import java.util.function.Supplier;


public class SimulationClock {
    private int currentTime = 0;
    private int tickRate = 1;

    public void advanceTime() {
        currentTime += tickRate;
    }

    public void scheduleEvent() {
        // Placeholder for future event scheduling
    }

    public int getTime() {
        return currentTime;
    }

    public void reset() {
        currentTime = 0;
    }
}
