package ikm;

public class UnnamedThread {

    public static void main(String[] args) {
        Runnable r = () -> System.out.println("aa");
        new Thread(r).start();
    }
}
