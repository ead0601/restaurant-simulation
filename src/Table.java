public class Table implements SimProcess {
    private int tickCounter = 0;
    private int nextTickCounter = 0;

    @Override
    public boolean evaluate() { nextTickCounter = tickCounter + 1; return true; }
    @Override
    public void commit() { tickCounter = nextTickCounter; if (tickCounter % 1000 == 0) System.out.println("[Table] Tick: " + tickCounter); }
    @Override
    public String[][] getState() { return new String[][] { { "tickCounter", String.valueOf(tickCounter) } }; }
}
