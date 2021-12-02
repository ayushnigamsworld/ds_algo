package medium.arraysAndStrings;

import java.util.Arrays;

public class SearchRotatedArray {

    public static void main(String[] args) {
        // 4,5,6,7,0,1,2
        // 6,7,1,2,3,4,5
        // 7,1,2,3,4,5,6
        // 2,3,4,5,6,7,1
        // 3,5,1
        int[] inp = new int[]{3,5,1};
        int target = 3;
        System.out.println(new SearchRotatedArray().rotatedSearch(inp, target));
    }

    public int rotatedSearch(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0: -1;
        }
        int pivot = binarySearchPivot(0, nums.length-1, nums);
        int res = 0;
        if (pivot == -1) {
            res = Arrays.binarySearch(nums, 0, nums.length, target);
            return res >=0 ? res : -1;
        }
        if (nums[pivot] == target) return pivot;
        int highest = nums[pivot];
        if (nums[0] <= target && target <= highest) {
            res = Arrays.binarySearch(nums, 0, pivot+1, target);
        } else {
            res = Arrays.binarySearch(nums, pivot+1, nums.length, target);
        }
        return res >=0 ? res : -1;
    }

    private int binarySearchPivot(int low, int high, int[] nums) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high)/ 2;
        if (mid == nums.length - 1) {
            return -1;
        }
        if (nums[mid] > nums[mid+1]) {
            return mid;
        }
        if (nums[low] > nums[mid]) {
            return binarySearchPivot(low, mid-1, nums);
        }
        return binarySearchPivot(mid+1, high, nums);
    }
}
