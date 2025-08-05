public class Restaurant extends SimEntity {
    private double revenue;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"revenue", String.valueOf(revenue)} };
    }
}
