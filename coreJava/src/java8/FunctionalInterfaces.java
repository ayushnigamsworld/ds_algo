package java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FunctionalInterfaces {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        Runnable calculateTax = new Runnable() {
            @Override
            public void run() {

            }
        };

        // This above is a functionality passed as an object to threadpool.
        // FunctionalInterface are interfaces which represent functionality and yonot simple data.

        threadPool.submit(calculateTax);
    }
}
