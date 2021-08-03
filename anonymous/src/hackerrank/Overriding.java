package hackerrank;

public class Overriding {
    public static void main(String[] args) {
        B b= new B();
        C c = new C();
        b = c;
        printName(b);
    }
    public static void printName(A a) {
        a.printName();
    }
}

class A {
    public void printName() {
        System.out.println("A");
    }
}

class B extends A {
    public void printName() {
        System.out.println("B");
    }
}

class C extends B {
    public void printName() {
        System.out.println("C");
    }
}