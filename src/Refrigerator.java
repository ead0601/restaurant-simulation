import java.util.*;
import java.util.function.Supplier;


public class Refrigerator extends SimEntity {
    public Refrigerator() {
        registerLoggables();
    }

    public void registerLoggables() {
        SimulationManager manager = SimulationManagerSingleton.getInstance();
        manager.registerLoggables("Refrigerator", new HashMap<>()); // Add variable suppliers as needed
    }

    public void triggerLog() {
        SimulationManagerSingleton.getInstance().triggerLog("Refrigerator");
    }
}
