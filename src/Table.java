public class Table extends SimEntity {
    private int capacity;
    private boolean occupied;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"capacity", String.valueOf(capacity)}, new String[]{"occupied", String.valueOf(occupied)} };
    }
}
