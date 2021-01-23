package sorting;

import java.util.ArrayList;
import java.util.List;

public class VonageInterview {

    private static boolean isSorted = true;
    public static void main(String[] args) {
        String arr[] = {"abc1hdj8894f9-45hj", "abc954hdj8894f9-45hj", "abc01234hdj894f9-45hj", "abc1234hdj8894f9-45hj", "abc1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj", "xyz012345hdj8894f9-45hj", "x012345hdj8894f9-45hj"};
        System.out.println(solution(arr));
    }

    public static boolean solution(String[] arr) {
        // write your code in Java SE 8
        for (int i=0; i<arr.length-2; i++) {
            if (!compareCustom(arr[i], arr[i+1]) ) {
                return false;
            }
        }
        return true;
    }



    /**
     *
     * Check sequentially for each string,
        str1 = current, st2 = next
        Comparing str1, str2
     * 1. Length of whole string. (Smaller is first)
     * 2. Dividing str1 and str2 into chunks of alpha1, num1, -, alpha2, num2
     3. If chunk is num, then check for padding of 0s and trim it.
     4. Comparing each chunk sequentially
     5. chunkstr1 is chunk1 of str1 and chunkstr2 is chunk1 of str2
     6. if chunkstr1 = num and chunkstr2 = alpha then not sorted
     7. if chunkstr1 = num and chunkstr2 = num and chunkstr1 > chunkstr2 then not sorted
     8. if chunkstr1 = alpha and chunkstr2 = alpha and chunkstr1 > chunkstr2(lexicographically) then not sorted
     */
    private static boolean compareCustom(String s1, String s2) {
        if (s1.length() > s2.length()) { return false; }
        if (s1.equals(s2)) return true;
        List<String> chunkstr1 = produceChunks(s1);
        List<String> chunkstr2 = produceChunks(s2);
        int size = chunkstr1.size() < chunkstr2.size() ? chunkstr1.size() : chunkstr2.size();
        int i = 0;
        while (i < size) {
            if (Character.isDigit(chunkstr1.get(i).charAt(0)) && Character.isAlphabetic(chunkstr2.get(i).charAt(0))) {
                return false;
            }
            if (Character.isDigit(chunkstr1.get(i).charAt(0)) && Character.isDigit(chunkstr2.get(i).charAt(0))) {
                if ( Integer.parseInt(chunkstr1.get(i)) > Integer.parseInt(chunkstr2.get(i)) ) {
                    return false;
                }
            }
            if (Character.isAlphabetic(chunkstr1.get(i).charAt(0)) && Character.isAlphabetic(chunkstr2.get(i).charAt(0))) {
                if (chunkstr1.get(i).compareTo(chunkstr2.get(i)) > 0) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    private static List<String> produceChunks(String s) {
        List<String> chunks = new ArrayList<>();
        int i=0;
        while (i<s.length()) {
            String temp = "";
            while (i<s.length() && isAlpha(s.charAt(i))) {
                temp += s.charAt(i);
                i++;
            }
            if (!temp.isEmpty()) {
                chunks.add(temp);
                continue;
            }
            while (i<s.length() && Character.isDigit(s.charAt(i))) {
                temp += s.charAt(i);
                i++;
            }
            if (!temp.isEmpty()) {
                temp = Integer.valueOf(temp).toString();
                chunks.add(temp);
                continue;
            }
            i++;
        }
        return chunks;
    }

    private static boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
