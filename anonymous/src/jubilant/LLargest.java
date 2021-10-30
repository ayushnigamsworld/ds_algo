package jubilant;

import java.util.Stack;

public class LLargest {

    public static void main(String[] args) {


        // ck stack = ..

        // 2, 4, 76, 45, 98, 67

        // 67
        // 98 top 98 > 67
        // pop 67
        // push 98
        // 45 compares top 45 < 98
        // 45 -> 98
        // sit on top push
        // 45 -> 98
        // 76
        // 76 > 45 pop 45
        // 76 > 98 76 -> 98
        // push 76
        // 76 -> 98
        // 4 < 76 compare top
        // 4 -> 76
        // push 4 -> 76 -> 98
        // 2 < 4
        // 2 -> 4
        // 2 -> 4 -> 76 -> 98

        // O (n) time  O(n) space
    }
}
