import java.util.*;

public class GlobalVariables {
    protected Map<String, Double> customerParameters;
    protected Map<String, Double> kitchenParameters;
    protected Map<String, Double> staffingParameters;
    protected Map<String, Double> environmentalParameters;
    protected Map<String, Object> simulationConfig;

    public GlobalVariables() {
        customerParameters = new HashMap<>();
        kitchenParameters = new HashMap<>();
        staffingParameters = new HashMap<>();
        environmentalParameters = new HashMap<>();
        simulationConfig = new HashMap<>();
    }

    public double getProbability(String category, String event) {
        // TODO: Retrieve probability value
        return 0.0;
    }

    public double sampleProbability(String category, String event) {
        // TODO: Sample probability logic
        return 0.0;
    }

    public void adjustProbability(String category, String event, double delta) {
        // TODO: Adjust probability logic
    }

    public boolean evaluateOutcome(String category, String event) {
        // TODO: Evaluate probability outcome
        return false;
    }
}
