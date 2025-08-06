public class Oven {
    public void startCooking(Platter p) {
        System.out.println("Oven is cooking: " + p.getName());
    }

    public void advanceTime() {
        System.out.println("Oven advancing time.");
    }
}