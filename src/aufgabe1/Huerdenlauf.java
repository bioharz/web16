package aufgabe1;

/**
 * Created by bioharz on 10/04/17.
 */
public class Huerdenlauf {

    public static void main(String[] args) {
        final int GES_LAUF = 2000;
        final int OUTER_LOOP_COUNTER = 200;
        int innerLoopCounter = 0;
        final int HURDLES = 6;
        int hurdleCounter = 0;


        System.out.println("Startschuss");
        for (int meterCounter = 0; meterCounter <= GES_LAUF; meterCounter++) {

            if (meterCounter != 0 && meterCounter != GES_LAUF) {

                if (meterCounter % OUTER_LOOP_COUNTER == 0) {
                    innerLoopCounter++;
                    System.out.println("Der Läufter befindet sich in der " + innerLoopCounter + " Runde.");
                }

                if (meterCounter % (OUTER_LOOP_COUNTER / HURDLES) == 0) {
                    hurdleCounter++;
                    if (hurdleCounter == 24) System.out.println("go go go");
                    System.out.println(hurdleCounter + " Hürde Überwunden");
                }

            }
            if (meterCounter == (GES_LAUF / 2)) System.out.println("Häfte geschafft");
            if (meterCounter == GES_LAUF) System.out.println("Ziel geschafft");

        }

    }
}
