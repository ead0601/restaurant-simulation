public class Server extends SimEntity {
    private int tablesAssigned;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"tablesAssigned", String.valueOf(tablesAssigned)} };
    }
}
