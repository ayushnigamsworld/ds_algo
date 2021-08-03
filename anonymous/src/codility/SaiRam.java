package codility;

import java.util.Stack;
import java.util.Vector;

public class SaiRam {

    public static void main(String[] args) {
        String aa= "asa";
        aa.chars().forEach(System.out::print);

        int inp[]= new int[]{0,0,1, 1, 1, 0, 0, 1, 0, 0};
        Stack<Integer> stack = new Stack<>();
        int lastLimit = inp.length-1;
        while (inp[lastLimit] == 0) {
            lastLimit --;
        }
        for (int i=0; i<=lastLimit; i++) {
            int current = inp[i];
            if (current == 1) {
                stack.push(1);
            } else if (current == 0 && !stack.isEmpty()) {
                int top = stack.peek();
                if (top == 1) {
                    stack.push(0);
                }
            }
        }
        System.out.println(stack.size());
    }
}
