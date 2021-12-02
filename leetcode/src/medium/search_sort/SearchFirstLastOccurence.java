package medium.search_sort;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/802/
public class SearchFirstLastOccurence {

    public static void main(String[] args) {
        int[] nums = new int[] {7,7,7,8,8,9};
        SearchFirstLastOccurence s = new SearchFirstLastOccurence();
        int target = 7;
        int[] res = s.searchRange(nums, target);
        for (int a: res) {
            System.out.println(a);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = startRecurse(0, nums.length-1, nums, target);
        if (start == -1) {
            return new int[]{-1, -1};
        }
        if (start == nums.length-1 || nums[start+1] != target) {
            return new int[]{start, start};
        }
        int end = endRecurse(start+1, nums.length-1, nums, target);
        return new int[]{start, end};
    }

    private int startRecurse(int low, int high, int[] nums, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target && (mid == 0 || nums[mid-1] != target)) {
            return mid;
        }
        if (nums[mid] > target || nums[mid] == target) {
            return startRecurse(low, mid-1, nums, target);
        }
        return startRecurse(mid+1, high, nums, target);
    }

    private int endRecurse(int low, int high, int[] nums, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target && (mid == nums.length-1 || nums[mid+1] != target)) {
            return mid;
        }
        if (nums[mid] <= target) {
            return endRecurse(mid+1, high, nums, target);
        }
        return endRecurse(low, mid-1, nums, target);
    }
}
