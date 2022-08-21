package cyclicSort;

public class DuplicateAndMissing {

    public static void main(String[] args) {
        findNumbers(new int[] {3, 1, 2, 5, 2});
    }

    public static int[] findNumbers(int[] nums) {
        int[] result = new int[2];
        for (int i=0; i<nums.length; i++) {
            if (nums[i]-1 == i) {
                continue;
            }
            while (nums[i]-1 != i) {
                if (nums[nums[i]-1] == nums[i]) {
                    result[0] = nums[i];
                    result[1] = i+1;
                    break;
                }
                swap(nums, i, nums[i]-1);
            }
        }
        return result;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
