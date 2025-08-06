public class Main {
    public static void main(String[] args) {
        SimulationClock clock = new SimulationClock(1);
        HeartbeatManager hb = new HeartbeatManager(clock);

        // Create simulation objects
        Restaurant restaurant = new Restaurant();
        Cook cook = new Cook();
        Customer customer = new Customer();
        Server server = new Server();
        Table table = new Table();
        Inventory inventory = new Inventory();

        // Register objects
        hb.registerProcess(clock);
        hb.registerProcess(restaurant);
        hb.registerProcess(cook);
        hb.registerProcess(customer);
        hb.registerProcess(server);
        hb.registerProcess(table);
        hb.registerProcess(inventory);

        // Preload some sample inventory for testing
        inventory.addIngredient("Tomato", 10, 0.5);
        inventory.addIngredient("Cheese", 5, 1.0);
        inventory.addIngredient("Pasta", 8, 0.8);

        System.out.println("Simulation initialized with sample inventory.");
        hb.startConsole();
    }
}
