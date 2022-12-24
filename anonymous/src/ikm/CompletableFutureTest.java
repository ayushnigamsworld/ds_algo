package ikm;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    public static int gradeSchoolFinished() {
        System.out.println("G");
        return 5;
    }

    public static int highSchoolFinished() {
        System.out.println("H");
        return 6;
    }

    public static int undergradeFinished() {
        System.out.println("U");
        return 7;
    }

    public static int mastersFinished() {
        System.out.println("M");
        return 8;
    }

    public static int getAJob() {
        System.out.println("J");
        return 9;
    }

    public static void main(String[] args) throws Exception {
        CompletableFuture carrer = CompletableFuture.runAsync(() -> gradeSchoolFinished())
                .thenApply(x -> highSchoolFinished())
                .thenApply(y -> undergradeFinished())
                .thenApply(z -> mastersFinished())
                .exceptionally(a -> getAJob());
        System.out.println(carrer.get());
    }

}
