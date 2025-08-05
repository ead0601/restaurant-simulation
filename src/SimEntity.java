public abstract class SimEntity implements SimProcess {
    protected int tickCounter = 0;
    protected int nextTickCounter = 0;

    @Override
    public boolean evaluate() {
        nextTickCounter = tickCounter + 1;
        return true;
    }

    @Override
    public void commit() {
        tickCounter = nextTickCounter;
    }

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)} };
    }
}
