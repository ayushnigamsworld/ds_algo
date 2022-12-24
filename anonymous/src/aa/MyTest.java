package aa;

import java.util.HashSet;
import java.util.Set;

public class MyTest {

    public static void main(String[] args) {

        //System.out.println("1:" +Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        // myThread.start();
        //System.out.println(Thread.currentThread().getName());
        int[] first = {3, 5, 7, 9, 11, 13};
        int[] second = {3, 5, 7, 11, 13};
        int missingIndex = findMissing(second, first);
        System.out.println("Missing Index:: "+ missingIndex);
    }

    private static int findMissing(int[] first, int[] second) {
        Set<Integer> cache = new HashSet<>();
        for (int i: first) {
            cache.add(i);
        }
        for (int i=0; i<second.length; i++) {
            if (!cache.contains(second[i])) {
                return i;
            }
        }
        return -1;
    }

}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Yes");
    }
}

