import java.util.*;
import java.util.function.Supplier;


public class Restaurant extends SimEntity {
    public Restaurant() {
        registerLoggables();
    }

    public void registerLoggables() {
        SimulationManager manager = SimulationManagerSingleton.getInstance();
        manager.registerLoggables("Restaurant", new HashMap<>()); // Add variable suppliers as needed
    }

    public void triggerLog() {
        SimulationManagerSingleton.getInstance().triggerLog("Restaurant");
    }
}
