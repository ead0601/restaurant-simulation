import java.util.*;
import java.util.function.Supplier;


public class Inventory extends SimEntity {
    private Map<String, Integer> items = new HashMap<>();
    private Map<String, Double> costs = new HashMap<>();

    public void addItem(String name, int quantity) {
        items.put(name, quantity);
    }

    public void setCost(String name, double cost) {
        costs.put(name, cost);
    }

    public int getQuantity(String name) {
        return items.getOrDefault(name, 0);
    }

    public double getCost(String name) {
        return costs.getOrDefault(name, 0.0);
    }

    public void registerLoggables() {
        SimulationManager manager = SimulationManagerSingleton.getInstance();
        manager.registerLoggables("Inventory", new HashMap<>());
    }

    public void triggerLog() {
        SimulationManagerSingleton.getInstance().triggerLog("Inventory");
    }
}
