package imocha.medium;

public class ParentFolderMinSteps {

    public static void main(String[] args) {


        String str = "cde";
        char c = str.charAt(0);
        c = (char)(c - 1);
        System.out.println(c);

//        byte a = 10;
//        float b;
//        int c;
//        b = (float) ++a * a;
//        c = (short)b;
//        /*System.out.println(a++ + ++b + .1);
//        System.out.println(b + .1);
//        System.out.println(c + .1);*/
//
//        runMe(new int[]{7, 3, -1});
    }

    private static void runMe(int a[]) {
        a[1]--;
        System.out.println(a[1] * 2);
    }
}
