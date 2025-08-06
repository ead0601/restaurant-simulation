public class Ingredient {
    private String name;
    private double quantity;
    private double unitCost;

    public Ingredient(String name, double quantity, double unitCost) {
        this.name = name;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    public String getName() { return name; }
    public double getQuantity() { return quantity; }
    public double getUnitCost() { return unitCost; }

    public void addQuantity(double amount) { this.quantity += amount; }
    public void reduceQuantity(double amount) { this.quantity -= amount; }
}
