import java.util.*;
import java.util.function.Supplier;


public class Order extends SimEntity {
    public Order() {
        registerLoggables();
    }

    public void registerLoggables() {
        SimulationManager manager = SimulationManagerSingleton.getInstance();
        manager.registerLoggables("Order", new HashMap<>()); // Add variable suppliers as needed
    }

    public void triggerLog() {
        SimulationManagerSingleton.getInstance().triggerLog("Order");
    }
}
