package hackerrank.hcl.javaspringbootkafka;

public class TestThreads {

    public static void main(String[] args) {
        Thread t = new MyThread() {
            public void run() {
                System.out.println(" foo");
            }
        };
        t.start();
    }
}

class MyThread extends Thread {
    MyThread() {
        System.out.println(" MyThread");
    }

    public void run() {
        System.out.println(" bar");
    }

    public void run(String s) {
        System.out.println(" baz");
    }
}
