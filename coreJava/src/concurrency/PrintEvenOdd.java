package concurrency;

public class PrintEvenOdd {

    // Starting counter
    int counter = 1;

    static int N;

    // Function to print odd numbers
    public void printOddNumber()
    {
        System.out.println("PrintOdd:: ThreadName:: "+ Thread.currentThread().getName());
        synchronized (this)
        {
            // Print number till the N
            while (counter < N) {

                // If count is even then print
                while (counter % 2 == 0) {

                    // Exception handle
                    try {
                        System.out.println("PrintOdd:: Before Wait:: "+ Thread.currentThread().getName());
                        wait();
                    }
                    catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                // Print the number
                System.out.println(counter + " ");
                System.out.println("PrintOdd:: After Wait:: "+ Thread.currentThread().getName());

                // Increment counter
                counter++;

                // Notify to second thread
                System.out.println("Notifying:: PrintOdd");
                notify();
            }
        }
    }

    // Function to print even numbers
    public void printEvenNumber()
    {
        synchronized (this)
        {
            System.out.println("PrintEven:: ThreadName:: "+ Thread.currentThread().getName());
            // Print number till the N
            while (counter < N) {

                // If count is odd then print
                while (counter % 2 == 1) {

                    // Exception handle
                    try {
                        System.out.println("PrintEven:: Before Wait:: "+ Thread.currentThread().getName());
                        wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                // Print the number
                System.out.println(counter + " ");
                System.out.println("PrintEven:: After Wait:: "+ Thread.currentThread().getName());

                // Increment counter
                counter++;

                // Notify to 2nd thread
                System.out.println("Notifying:: PrintEven");
                notify();

            }
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Given Number N
        N = 10;

        // Create an object of class
        PrintEvenOdd mt = new PrintEvenOdd();

        // Create thread t1
        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                mt.printEvenNumber();
            }
        });

        // Create thread t2
        Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                mt.printOddNumber();
            }
        });

        // Start both threads
        t1.start();
        t2.start();
    }
}
