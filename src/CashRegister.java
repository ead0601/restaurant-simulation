import java.util.*;
import java.util.function.Supplier;


public class CashRegister extends SimEntity {
    public CashRegister() {
        registerLoggables();
    }

    public void registerLoggables() {
        SimulationManager manager = SimulationManagerSingleton.getInstance();
        manager.registerLoggables("CashRegister", new HashMap<>()); // Add variable suppliers as needed
    }

    public void triggerLog() {
        SimulationManagerSingleton.getInstance().triggerLog("CashRegister");
    }
}
