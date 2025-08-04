public interface SimProcess {
    boolean evaluate();    // Compute next state
    void commit();         // Commit next state
    String[][] getState(); // Return state for waveform/debug
}
