import java.util.*;
import java.util.function.Supplier;


public class Main {
    public static void main(String[] args) {
        SimulationManager manager = SimulationManagerSingleton.getInstance();
        manager.startConsole();
    }
}
