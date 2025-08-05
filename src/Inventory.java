public class Inventory extends SimEntity {
    private int stockLevel;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"stockLevel", String.valueOf(stockLevel)} };
    }
}
