public class ServerTable extends SimEntity {
    private boolean bell;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"bell", String.valueOf(bell)} };
    }
}
