package walmart;

public class Test1 {

    public static void main(String[] args) {

    }

    private void createDeadlock() throws InterruptedException {
        MyResource myResource = new MyResource();
        Thread t1 = new Thread(() -> {
            try {
                myResource.increment();
            } catch (Exception e) {

            }
        });

        Thread t2 = new Thread(() -> {
            try {
                myResource.decrement();
            } catch (Exception e) {

            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class MyResource {
   int count  = 0;
   public void increment() throws InterruptedException {
       synchronized (this) {
           count++;
           wait();
       }
   }

   public void decrement() throws InterruptedException {
       synchronized (this) {
           count++;
           wait();
       }
   }
}
