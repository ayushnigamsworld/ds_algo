package ikm;

import java.util.concurrent.CompletableFuture;

public class AsyncWork implements Runnable {
    @Override
    public void run() {
        System.out.println("hii run");
    }
}

class Testing {
    public static void main(String[] args) {
        AsyncWork myWork = new AsyncWork();
        Thread m = new Thread(myWork);
        m.start();
        // Thread.start();
        CompletableFuture cp = CompletableFuture.runAsync(myWork);
        cp.join();
    }
}
