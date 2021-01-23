package Arrays;

import java.util.ArrayList;
import java.util.List;

public class RotateGroup {

    public static void main(String aa[]) {
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(1);ls.add(2);ls.add(3);ls.add(4);ls.add(5);ls.add(6);ls.add(7);ls.add(8);
        //ls.add(5);ls.add(6);ls.add(8);ls.add(9);
        System.out.println(reverseInGroups(ls, 8, 3));
    }
    public static List<Integer> reverseInGroups(List<Integer> mv, int n, int k) {
        // add your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i <n; i+=k) {
            int start = i + k - 1;
            int end = i;
            if (start >= n) {
                start = n -1;
            }
            while(start>end) {
                int temp = mv.get(start);
                mv.set(start, mv.get(end));
                mv.set(end, temp);

                start--;
                end++;
            }
        }
        return mv;
    }
}
