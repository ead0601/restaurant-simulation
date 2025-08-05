public class Cook extends SimEntity {
    private boolean busy;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"busy", String.valueOf(busy)} };
    }
}
