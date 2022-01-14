package aa;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInt {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger);
        atomicInteger.set(10);
        System.out.println(atomicInteger.getAndSet(22));
        System.out.println(atomicInteger.get());

    }
}
