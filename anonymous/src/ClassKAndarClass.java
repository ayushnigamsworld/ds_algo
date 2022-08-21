abstract class ClassKAndarClass {
    abstract void myFunc();
    int myFunc2() {
        return 1;
    }
    static class InnerClass {
        public int a = 5;
    }
}

class DusriBaharClass extends ClassKAndarClass {

    void myFunc() {

    }
    public static void main(String[] args) {
        InnerClass my = new DusriBaharClass.InnerClass();
        System.out.println("Child ka bachha " + my.a);
        InnerClass mmm = new ClassKAndarClass.InnerClass();

    }
}
