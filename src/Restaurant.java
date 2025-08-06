import java.util.*;
import java.util.function.Supplier;


public class Restaurant extends SimEntity {
    private Inventory inventory;
    private Map<String, Platter> platters;

    public Restaurant() {
        registerLoggables();
        this.inventory = new Inventory();
        this.platters = new HashMap<>();
    }

    public void registerLoggables() {
        SimulationManager manager = SimulationManagerSingleton.getInstance();
        manager.registerLoggables("Restaurant", new HashMap<>());
    }

    public void triggerLog() {
        SimulationManagerSingleton.getInstance().triggerLog("Restaurant");
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setPlatters(Map<String, Platter> platters) {
        this.platters = platters;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public Map<String, Platter> getPlatters() {
        return this.platters;
    }
}
