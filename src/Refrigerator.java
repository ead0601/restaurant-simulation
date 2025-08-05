public class Refrigerator extends SimEntity {
    private double temperature;

    @Override
    public String[][] getState() {
        return new String[][] { {"tickCounter", String.valueOf(tickCounter)}, new String[]{"temperature", String.valueOf(temperature)} };
    }
}
