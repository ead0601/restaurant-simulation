import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimulationClock clock = new SimulationClock(1);
        HeartbeatManager hb = new HeartbeatManager(clock);

        // Register simulation objects
        Restaurant restaurant = new Restaurant();
        Cook cook = new Cook();
        Customer customer = new Customer();
        Server server = new Server();
        hb.registerProcess(clock);
        hb.registerProcess(restaurant);
        hb.registerProcess(cook);
        hb.registerProcess(customer);
        hb.registerProcess(server);

        // Waveform Debug
        WaveformViewer wf = new WaveformViewer(hb, List.of(clock, restaurant, cook, customer, server));
        System.out.println("=== Debug Simulation Start ===");
        wf.runDebug(50); // Run 50 ticks for demo

        // Full simulation run
        System.out.println("=== Full Simulation Start ===");
        hb.run(5000); // Run simulation
    }
}
