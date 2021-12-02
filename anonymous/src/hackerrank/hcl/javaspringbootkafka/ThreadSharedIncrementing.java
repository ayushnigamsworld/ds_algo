package hackerrank.hcl.javaspringbootkafka;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadSharedIncrementing {

    private static int x = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future future = executorService.submit(new Runnable() {
            public void run() {
                for (int i=0; i<100; i++) {
                    System.out.println("--");
                    x = x + 1;
                }
            }
        });
        future.get();
        System.out.println(x);
    }
}
