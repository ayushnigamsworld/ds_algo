package glider;

import sun.misc.GC;

public class GarbageCollection {

    public static void main(String[] args) {
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
