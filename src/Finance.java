import java.util.*;
import java.util.function.Supplier;


public class Finance extends SimEntity {
    public Finance() {
        registerLoggables();
    }

    public void registerLoggables() {
        SimulationManager manager = SimulationManagerSingleton.getInstance();
        manager.registerLoggables("Finance", new HashMap<>()); // Add variable suppliers as needed
    }

    public void triggerLog() {
        SimulationManagerSingleton.getInstance().triggerLog("Finance");
    }
}
