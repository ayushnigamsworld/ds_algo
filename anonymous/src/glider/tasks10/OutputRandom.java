package glider.tasks10;

import java.util.Random;

public class OutputRandom {

    public static void main(String[] args) {
        Random r = new Random();
        for (int i=0; i<3; i++) {
            System.out.print(r.ints(1, 5, 11).findFirst().getAsInt());
        }
    }
}
