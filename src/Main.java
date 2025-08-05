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

        // Register objects
        hb.registerProcess(clock);
        hb.registerProcess(restaurant);
        hb.registerProcess(cook);
        hb.registerProcess(customer);
        hb.registerProcess(server);
        hb.registerProcess(table);

        // Start debug console
        hb.startConsole();
    }
}
