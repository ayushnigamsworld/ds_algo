package anonymousTesting;

public class Abc {

    public static void main(String[] args) {
        final String r1 = "lex";
        final String r2 = "toy";
        Thread t1 = new Thread() {
            public void run() {
                synchronized (r1) {
                    System.out.println("t1 : locked r1");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
                synchronized (r2) {
                    System.out.println("t1 : locked r2");
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                synchronized (r2) {
                    System.out.println("t2 : locked r2");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
                synchronized (r1) {
                    System.out.println("t2 : locked r2");
                }
            }
        };
        t1.start();
        t2.start();
    }
}
