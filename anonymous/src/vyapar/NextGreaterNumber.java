package vyapar;

import java.util.Arrays;

/**
 *
 *
 * Input:  n = "218765"
   Output: "251678"

   218765 -> 2 1 8765 -> 2 1 876 5 -> 2 5 876 1 -> 258761 -> 25 8761 -> 25 1678 -> 251678

   Input:  n = "1234"
   Output: "1243"

   Input: n = "4321"
   Output: "Not Possible"

   Input: n = "534976"
   Output: "536479"
 *
 */
public class NextGreaterNumber {

    public static void main(String[] args) {
        NextGreaterNumber nextGreaterNumber = new NextGreaterNumber();
        int res = nextGreaterNumber.nextHigher(218765);
        System.out.println(res);
    }

    public int nextHigher(int n) {
        String num = Integer.toString(n);
        char inp[] = num.toCharArray();
        int smallerThanNextIndex = findFirstDigitSmallerThanPrevious(inp);
        if (smallerThanNextIndex == -1) {
            return -1;
        }

        int minIndex = findSmallestOnRightGreaterThanGiven(inp,
                smallerThanNextIndex + 1, inp[smallerThanNextIndex]);

        char temp = inp[smallerThanNextIndex];
        inp[smallerThanNextIndex] = inp[minIndex];
        inp[minIndex] = temp;

        Arrays.sort(inp, smallerThanNextIndex+1, inp.length);
        return Integer.parseInt(new String(inp));
    }

    private int findFirstDigitSmallerThanPrevious(char inp[]) {
        int current = inp.length - 1;
        while (current-1 >= 0) {
            if (inp[current-1] < inp[current]) {
                return current-1;
            }
            current --;
        }
        return -1;
    }

    private int findSmallestOnRightGreaterThanGiven(char inp[], int startIndex, int k) {
        int minIndex = startIndex;
        while (startIndex < inp.length) {
            if (inp[startIndex] < inp[minIndex] && inp[minIndex] > k) {
                minIndex = startIndex;
            }
            startIndex++;
        }
        return minIndex;
    }
}
