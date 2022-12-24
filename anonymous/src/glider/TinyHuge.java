package glider;

public class TinyHuge {

    public static void main(String[] args) {
        int x = 20;
        String sup = x < 15 ? "Small" : (x < 22) ? "Tiny" : "Huge";
        System.out.println(sup);
    }
}
