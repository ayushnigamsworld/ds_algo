package concurrency;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ManyThreads {

    private static Integer x = 0;
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                for (int i=0; i<100; i++) {
                    x++;
                }
                return "Done 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                for (int i=0; i<100; i++) {
                    x++;
                }
                return "Done 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                for (int i=0; i<100; i++) {
                    x++;
                }
                return "Done 3";
            }
        });

        List<Future<String>> futures = executorService.invokeAll(callables);

        for(Future<String> future : futures){
            System.out.println("future.get = " + future.get());
        }

        System.out.println(x);

        executorService.shutdown();
    }
}
