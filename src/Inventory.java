import java.util.*;
import java.util.function.Supplier;


public class Inventory extends SimEntity {
    public Inventory() {
        registerLoggables();
    }

    public void registerLoggables() {
        SimulationManager manager = SimulationManagerSingleton.getInstance();
        manager.registerLoggables("Inventory", new HashMap<>()); // Add variable suppliers as needed
    }

    public void triggerLog() {
        SimulationManagerSingleton.getInstance().triggerLog("Inventory");
    }
}
