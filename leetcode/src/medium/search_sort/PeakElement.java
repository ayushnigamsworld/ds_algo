package medium.search_sort;

public class PeakElement {

    public static void main(String[] args) {
        int[] nums = new int[] {3,4,3,2,1};
        PeakElement peakElement = new PeakElement();
        System.out.println(peakElement.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        return recurse(0, nums.length-1, nums);
    }

    private int recurse(int low, int high, int[] nums) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high)/2;
        if ((mid == 0 && nums[mid+1] < nums[mid])
                || (mid == nums.length-1 && nums[mid-1] < nums[mid])
                || (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1] )) {

            return mid;

        } else if ( nums[mid+1] > nums[mid]  ) {
            return recurse(mid+1, high, nums);

        }
        return recurse(low, mid, nums);
    }
}
