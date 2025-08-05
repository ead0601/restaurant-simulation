public interface SimProcess {
    boolean evaluate();
    void commit();
    String[][] getState();
}
