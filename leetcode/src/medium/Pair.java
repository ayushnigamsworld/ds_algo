package medium;

public class Pair implements Comparable {
    public int k, v;
    public Pair(int k, int v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public int compareTo(Object o) {
        Pair o2 = (Pair)o;
        int c = this.k - o2.k;
        if (c == 0) {
            c = this.v - o2.v;
        }
        return c;
    }
}
