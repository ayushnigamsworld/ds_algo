package ikm;

import java.util.function.Predicate;

public class MyPredicator<T> implements Predicate<T> {
    Predicate<T> local;
    MyPredicator(Predicate<T> t) {
        local = t;
    }

    @Override
    public boolean test(T t) {
        return local.test(t);
    }
}

class Predicator {
    static boolean testit(Object s, Predicate<Object> p) {
        return p.test(s);
    }

    public static void main(String[] args) {
        final String s1 = "HI";
        final Integer i1 = 3;
        final int x = 1;
        MyPredicator<Object>[] p = new MyPredicator[4];
        p[0] = new MyPredicator<>(e -> e.equals(s1));
        p[1] = new MyPredicator<>(e -> { if (x == 1) return e.equals(s1); return !e.equals(s1); });
        p[2] = new MyPredicator<>(e -> { if (x != 1) return e.equals(i1); return !e.equals(s1); });
        p[3] = new MyPredicator<>((Object e) -> { if (x != 1) return e.equals(i1); return !e.equals(s1); });

        for (MyPredicator<Object> pp: p) {
            System.out.println(testit(s1, pp));
        }
    }
}
