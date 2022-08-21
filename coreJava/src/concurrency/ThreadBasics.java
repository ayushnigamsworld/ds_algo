package concurrency;

public class ThreadBasics {

    public static void main(String[] args) throws InterruptedException {
        CommonResource commonResource = new CommonResource();
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("T1 >>");
                commonResource.fun1(true);
                System.out.println("T1 <<");
            } catch (Exception e) {

            }
        });
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("T2 >>");
                commonResource.fun1(false);
                System.out.println("T2 <<");
            } catch (Exception e) {
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
        //t2.join();
    }


}

class CommonResource {
    int x = 0;
    public void fun1(boolean isWait) throws InterruptedException {
        System.out.println("Fun1 Current Thread:: "+ Thread.currentThread().getName());
        synchronized (this) {
            if (isWait) {
                wait();
            } else {
                notify();
            }
            System.out.println("Fun1 Resumed Thread:: "+ Thread.currentThread().getName());
            // System.out.println("Fun1 X = " + x);
        }
    }

    public synchronized void fun2() throws InterruptedException {
        wait();
        System.out.println("Fun2 Current Thread:: "+ Thread.currentThread().getName());
        System.out.println("Fun2 X = " + x);
        System.out.println("Fun2");
    }
}
