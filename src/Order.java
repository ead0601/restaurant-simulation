public class Order extends SimEntity {
    private boolean orderReady;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"orderReady", String.valueOf(orderReady)} };
    }
}
