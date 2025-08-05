public class Platter extends SimEntity {
    private int cookingTime;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"cookingTime", String.valueOf(cookingTime)} };
    }
}
