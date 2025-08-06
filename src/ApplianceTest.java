import java.util.*;

public class ApplianceTest {
    public static void main(String[] args) {
        Stove stove = new Stove();
        Oven oven = new Oven();
        Microwave microwave = new Microwave();

        Platter salmon = new Platter("Grilled Salmon", 5);
        Platter pizza = new Platter("Margherita Pizza", 7);
        Platter mac = new Platter("Mac and Cheese", 3);

        System.out.println("Starting cooking...");
        stove.startCooking(salmon);
        oven.startCooking(pizza);
        microwave.startCooking(mac);

        for (int i = 0; i < 8; i++) {
            System.out.println("Tick " + i);
            stove.advanceTime();
            oven.advanceTime();
            microwave.advanceTime();
        }
    }
}
