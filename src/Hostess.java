public class Hostess extends SimEntity {
    private int guestsQueued;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"guestsQueued", String.valueOf(guestsQueued)} };
    }
}
