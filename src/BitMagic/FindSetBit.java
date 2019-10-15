package BitMagic;

public class FindSetBit {
    public static void main(String arrp[]) {
        int a = 8;
        int b = a >> 1;
        if (((a >> 1) & 1) == 1) {
            System.out.println("yes");
        }
        System.out.println(a);
        System.out.println(b);
        int evenBits = a & 0xAAAAAAAA;
    }
}
