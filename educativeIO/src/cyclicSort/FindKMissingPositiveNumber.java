package cyclicSort;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.educative.io/courses/grokking-the-coding-interview/q2LA7G0ANX0
 */
public class FindKMissingPositiveNumber {

    public static void main(String[] args) {
        findNumbers(new int[] {3, 2, 5, 1}, 3);
    }

    // [3, -1, 4, 5, 5], k=3
    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] >= nums.length || nums[i] < 0 || i == nums[i]-1) {
                continue;
            }
            while (nums[i] < nums.length && nums[i] > 0 && i != nums[i]-1) {
                if (nums[nums[i]-1] > 0 && nums[nums[i]-1] == nums[i]) {
                    break;
                }
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i]-1 != i) {
                missingNumbers.add(i+1);
                k--;
            }
        }

        return missingNumbers;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
