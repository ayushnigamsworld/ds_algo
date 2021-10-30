package concurrency;

public class SimpleThread {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Task());
        thread1.start();
        // try { Thread.sleep(2000);  } catch (Exception e) { }
        System.out.println(Thread.currentThread().getName());
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
