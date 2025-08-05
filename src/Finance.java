public class Finance extends SimEntity {
    private double netRevenue;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"netRevenue", String.valueOf(netRevenue)} };
    }
}
