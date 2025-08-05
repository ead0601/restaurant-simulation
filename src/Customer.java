public class Customer extends SimEntity {
    private int patience;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"patience", String.valueOf(patience)} };
    }
}
