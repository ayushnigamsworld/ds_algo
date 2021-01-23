package BitMagic;

public class Subsets {

    public static void main(String[] args) {
        int n = 4;
        for (short x = 0; x < (1 << n); x++) {
            System.out.println(n & x);
        }
    }
}
