public class Ingredient extends SimEntity {
    private double quantity;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"quantity", String.valueOf(quantity)} };
    }
}
