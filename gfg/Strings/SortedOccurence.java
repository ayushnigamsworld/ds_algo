package Strings;

public class SortedOccurence {
    public static void main(String[] args) {
        sortedOccurence("geeksforgeeks");
    }

    static void sortedOccurence(String inp) {
        int[] count = new int[26];
        for (int i=0; i< inp.length(); i++) {
            count[inp.charAt(i) - 97]++;
        }
        for (int i=0; i<26; i++) {
            if (count[i] > 0) {
                System.out.print((char)(i+97) + "->" + count[i] + " -- ");
            }
        }
    }
}
