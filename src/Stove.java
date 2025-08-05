public class Stove extends SimEntity {
    private int activeBurners;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"activeBurners", String.valueOf(activeBurners)} };
    }
}
