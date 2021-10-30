package ikm;

public class InnerClassOutput {

    private int data;
    InnerClassOutput(int d) {
        this.data = d;
    }
    public void display() {
        class Hello {
            public void yes() {
                data--;
            }
        }
        Hello hello = new Hello();
        hello.yes();
        System.out.println(data);
    }

    public static void main(String[] args) {
        InnerClassOutput innerClassOutput = new InnerClassOutput(3);
        innerClassOutput.display();
        // System.out.println(data);
    }
}

class OO {
    public static void main(String[] args) {
        InnerClassOutput innerClassOutput = new InnerClassOutput(3);
        innerClassOutput.display();
    }
}
