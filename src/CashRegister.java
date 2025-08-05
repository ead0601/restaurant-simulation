public class CashRegister extends SimEntity {
    private double balance;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"balance", String.valueOf(balance)} };
    }
}
