import java.util.*;
import java.util.function.Supplier;


public class Hostess extends SimEntity {
    public Hostess() {
        registerLoggables();
    }

    public void registerLoggables() {
        SimulationManager manager = SimulationManagerSingleton.getInstance();
        manager.registerLoggables("Hostess", new HashMap<>()); // Add variable suppliers as needed
    }

    public void triggerLog() {
        SimulationManagerSingleton.getInstance().triggerLog("Hostess");
    }
}
