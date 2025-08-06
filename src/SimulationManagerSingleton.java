import java.util.*;
import java.util.function.Supplier;


public class SimulationManagerSingleton {
    private static SimulationManager instance = new SimulationManager();
    public static SimulationManager getInstance() { return instance; }
}
