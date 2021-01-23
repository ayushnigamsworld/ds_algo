public class Permutations {

    public static void main(String[] args) {

        Permutations permutations = new Permutations();
        permutations.permutate("ABC", 0, 3);
    }

    public void permutate(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
            return;
        }
        for (int i = l; i< r; i++) {
            str = swap(str, l, i);
            permutate(str, l+1, r);
            str = swap(str, l, i);
        }
    }

    public String swap(String str, int l, int r) {
        char[] strArr = str.toCharArray();
        char temp = strArr[l];
        strArr[l] = strArr[r];
        strArr[r] = temp;
        return new String(strArr);
    }
}
