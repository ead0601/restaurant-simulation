public class SimulationClock extends SimEntity {
    private int currentTime;
    private int tickRate;

    public SimulationClock(int tickRate) {
        this.tickRate = tickRate;
        this.currentTime = 0;
    }

    public void advanceTime() { currentTime += tickRate; }
    public int getCurrentTime() { return currentTime; }

    @Override
    public boolean evaluate() {
        nextTickCounter = tickCounter + 1;
        return true;
    }

    @Override
    public void commit() {
        tickCounter = nextTickCounter;
        advanceTime();
    }

    @Override
    public String[][] getState() {
        return new String[][] {
            {"tickCounter", String.valueOf(tickCounter)},
            {"currentTime", String.valueOf(currentTime)}
        };
    }
}
