package hackerrank;


class SampleDemo implements Runnable {
    private Thread t;
    private String threadName;

    SampleDemo(String th) {
        this.threadName = th;
    }

    public void run() {
        while (true) {


            System.out.print(threadName);
            break;
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
public class ThreadQuiz {

    public static void main(String[] args) {
        SampleDemo sampleDemo = new SampleDemo("A");
        SampleDemo sampleDemo2 = new SampleDemo("B");

        sampleDemo2.start();
        sampleDemo.start();
    }
}
