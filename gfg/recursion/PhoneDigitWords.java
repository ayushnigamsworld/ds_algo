package recursion;

public class PhoneDigitWords {
    public static void main(String arr[]) {
        String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int N = 3;
        int a[] = {2, 3, 4};
        String[] modifiedStr = new String[N];
        for (int i=0;i< N; i++) {
            modifiedStr[i] = str[a[i]];
        }
        PhoneDigitWords phoneDigitWords = new PhoneDigitWords();
        phoneDigitWords.printWords(modifiedStr, "", 0, N);
    }
    private void printWords(String[] str, String output, int index, int N) {
        if (index == N) {
            System.out.println(output+ " ");
            return;
        }

        for (int i=0; i<str[index].length(); i++) {
            printWords(str, output + str[index].charAt(i), index + 1, N);
        }
    }
}
