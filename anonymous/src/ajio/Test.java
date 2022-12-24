package ajio;

public class Test {

    Test() {

    }
    public static void main(String[] args) {
        Test t = new B();
        // t.bark();
    }
}

class B extends Test {
    public void bark() {
        System.out.println("Bow");
    }
}