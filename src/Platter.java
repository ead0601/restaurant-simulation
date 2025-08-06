import java.util.*;
import java.util.function.Supplier;


public class Platter {

    public Platter(String name, int cookingTime) {
        this.name = name;
        this.cookingTime = cookingTime;
    }
    public Platter() {
        // Default constructor for InitFileLoader
    }
    
        private String name;
    private List<String> ingredients;
    private int cookingTime;
    private String appliance;
    private List<String> locations;
    private double cost;

    public void setName(String name) { this.name = name; }
    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }
    public void setCookingTime(int time) { this.cookingTime = time; }
    public void setAppliance(String appliance) { this.appliance = appliance; }
    public void setLocations(List<String> locations) { this.locations = locations; }
    public void setCost(double cost) { this.cost = cost; }

    public String getName() { return name; }
    public List<String> getIngredients() { return ingredients; }
    public int getCookingTime() { return cookingTime; }
    public String getAppliance() { return appliance; }
    public List<String> getLocations() { return locations; }
    public double getCost() { return cost; }
}
