package medium.search_sort;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/798/
 */
public class Sort012 {

    public static void main(String[] args) {
        Sort012 sort012 = new Sort012();
        int inp[] = new int[]{2, 1, 1, 1, 2, 0, 1, 0, 1, 2, 0};
        sort012.sort(inp);
        for (int i=0; i<inp.length; i++) {
            System.out.print(inp[i]);
        }
    }

    private void sort(int nums[]) {
        // Dutch national flag problemo
        int start = 0;
        int end = nums.length - 1;
        int current = 0;
        while (current <= end) {
            if (nums[current] == 0) {
                int temp = nums[current];
                nums[current] = nums[start];
                nums[start] = temp;
                start++;
                current++;
            }
            else if (nums[current] == 1) {
                current++;
            } else {
                int temp = nums[current];
                nums[current] = nums[end];
                nums[end] = temp;
                end--;
            }
        }
    }
}
