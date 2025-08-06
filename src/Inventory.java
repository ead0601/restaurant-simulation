import java.util.*;

public class Inventory extends SimEntity {
    private Map<String, Ingredient> ingredients = new HashMap<>();

    // Add or restock ingredient
    public void addIngredient(String name, double quantity, double unitCost) {
        if (ingredients.containsKey(name)) {
            ingredients.get(name).addQuantity(quantity);
        } else {
            ingredients.put(name, new Ingredient(name, quantity, unitCost));
        }
    }

    // Deduct ingredient for usage
    public boolean useIngredient(String name, double quantity) {
        if (ingredients.containsKey(name)) {
            Ingredient ing = ingredients.get(name);
            if (ing.getQuantity() >= quantity) {
                ing.reduceQuantity(quantity);
                return true;
            }
        }
        return false;
    }

    // Check availability for a recipe
    public boolean hasIngredients(Map<String, Double> recipe) {
        for (Map.Entry<String, Double> entry : recipe.entrySet()) {
            if (!ingredients.containsKey(entry.getKey()) ||
                ingredients.get(entry.getKey()).getQuantity() < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    // Deduct ingredients for recipe
    public void consumeIngredients(Map<String, Double> recipe) {
        for (Map.Entry<String, Double> entry : recipe.entrySet()) {
            useIngredient(entry.getKey(), entry.getValue());
        }
    }

    // Query specific ingredient
    public Ingredient getIngredient(String name) {
        return ingredients.get(name);
    }

    @Override
    public String[][] getState() {
        List<String[]> state = new ArrayList<>();
        state.add(new String[]{"tickCounter", String.valueOf(tickCounter)});
        for (Ingredient ing : ingredients.values()) {
            state.add(new String[]{ing.getName(), ing.getQuantity() + " units"});
        }
        return state.toArray(new String[0][]);
    }
}
