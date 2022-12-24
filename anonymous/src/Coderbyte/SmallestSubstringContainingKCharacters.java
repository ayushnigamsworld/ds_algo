package Coderbyte;

import java.util.*;

class SmallestSubstringContainingKCharacters {

    // Function
    static String Minimum_Window(char[] c1, char[] c2)
    {

        int cache[] = new int[256];

        // Answer
        int ans = Integer.MAX_VALUE; // length of ans
        int start = 0; // starting index of ans
        int count = 0;
        // creating map
        for (int i = 0; i < c2.length; i++) {
            if (cache[c2[i]] == 0)
                count++;
            cache[c2[i]]++;
        }

        // References of Window
        int startW = 0;
        int endW = 0;

        // Traversing the window
        while (endW < c1.length) {

            // Calculations
            cache[c1[endW]]--;
            if (cache[c1[endW]] == 0)
                count--;

            // Condition matching
            if (count == 0) {
                while (count == 0) {

                    // Sorting ans
                    if (ans > endW - startW + 1) {
                        ans = Math.min(ans, endW - startW + 1);
                        start = startW;
                    }

                    // Sliding I
                    // Calculation for removing I
                    cache[c1[startW]]++;
                    if (cache[c1[startW]] > 0)
                        count++;

                    startW++;
                }
            }
            endW++;
        }

        if (ans != Integer.MAX_VALUE)
            return String.valueOf(c1).substring(start,
                    ans + start);
        else
            return "-1";
    }

    public static void main(String[] args)
    {
        String s = "this is a test string";
        String t = "tist";

        System.out.print(Minimum_Window(s.toCharArray(),
                t.toCharArray()));
    }
}

// This code is contributed by 29AjayKumar
