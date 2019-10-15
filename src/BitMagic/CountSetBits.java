package BitMagic;

public class CountSetBits {
    public static void main(String aa[]) {
        System.out.println(countBits(7));
        System.out.println(countBits(5));
        System.out.println(countBits(8));
    }
    private static int countBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n -1);
            count++;
        }
        return count;
    }
}
