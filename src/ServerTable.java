import java.util.*;
import java.util.function.Supplier;


public class ServerTable extends SimEntity {
    public ServerTable() {
        registerLoggables();
    }

    public void registerLoggables() {
        SimulationManager manager = SimulationManagerSingleton.getInstance();
        manager.registerLoggables("ServerTable", new HashMap<>()); // Add variable suppliers as needed
    }

    public void triggerLog() {
        SimulationManagerSingleton.getInstance().triggerLog("ServerTable");
    }
}
