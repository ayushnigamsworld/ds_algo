package glider.Yoh;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Misc {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future;
        ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
        String name = "yo";
        System.out.println(String.format("Welcome to Ass, %s", name));
    }
}
