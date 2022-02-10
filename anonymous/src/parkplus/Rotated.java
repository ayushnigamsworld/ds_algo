package parkplus;

import java.util.Arrays;

public class Rotated {

    public static void main(String[] args) {
        Rotated rotated = new Rotated();
        int inp[] = {6,7,8,1,2,3,4,5};
        System.out.println(rotated.findPivot(inp));
        System.out.println(rotated.search(inp, 3));
    }

    public int search(int[] nums, int target) {
        int res = -1;
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int pivotIndex = findPivot(0, nums.length-1, nums);
        if (pivotIndex == -1) {
            res = Arrays.binarySearch(nums, target);
        }
        else if (target >= nums[0] && target <= nums[pivotIndex] ) {
            res = Arrays.binarySearch(nums, 0, pivotIndex+1, target);
        }
        else {
            res = Arrays.binarySearch(nums, pivotIndex+1, nums.length, target);
        }
        return res < 0 ? -1 : res;
    }

    private int findPivot(int[] nums) {
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length-2] > nums[nums.length-1] ) {
            return nums.length-1;
        }
        for (int i=1; i<nums.length; i++) {
            if ( nums[i-1] < nums[i] && nums[i] > nums[i+1]) {
                return i;
            } else if ( i < nums.length-1 && nums[i-1] > nums[i] && nums[i] < nums[i+1]) {
                return i;
            }
        }
        return -1;
    }
    private int findPivot(int low, int high, int[] nums) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low)/2;
        if ((mid == 0 && nums[mid] > nums[mid+1]) ||  (mid < nums.length-1 &&
                nums[mid-1] > nums[mid] && nums[mid] < nums[mid+1] )) {
            return mid;

        } else if (nums[mid] > nums[high]) {
            return findPivot(mid+1, high, nums);
        }
        return findPivot(low, mid-1, nums);
    }
}
