import java.util.List;

// 3 10 1 100 99

/*Brute:
        sort and second item O(nlogn)

        Optimized:
        2 pointers
        1st pointer max 2nd secondMax  O(n)

        Heap
        nHighest
        MinHeap of n


        */

public class SecondHighest {

    public static void main(String[] args) {

        int inp[] = { 1,-1,-2,4,5,-4 };
        System.out.println(secondHighest(inp));
    }

    private static int secondHighest(int[] inp) {
        if (inp.length == 0) {
            return -1;
        }
        if (inp.length == 1) {
            return inp[0];
        }
        int first = inp[0] > inp[1] ? inp[0] : inp[1];
        int second = first == inp[0] ? inp[1] : inp[0];
        for (int i=2; i< inp.length; i++) {
            if (inp[i] > second) {
                if (inp[i] > first) {
                    second = first;
                    first = inp[i];
                } else {
                    second = inp[i];
                }
            }
        }
        return second;
    }
}
