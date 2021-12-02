package medium.search_sort;

import java.util.PriorityQueue;
import java.util.Queue;

public class KLargest {

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,5,6,4};
        int k = 6;
        KLargest kLargest = new KLargest();
        // kLargest.findKthLargest(nums, k);
        kLargest.quickSelect(nums, k);
    }

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue( (a, b) -> (Integer)a - (Integer) b  );
        for (int i: nums) {
            heap.offer(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    public void quickSelect(int[] nums, int k) {
        int a = recurse(nums, 0, nums.length-1, k);
        System.out.println(a);
    }

    private int recurse(int[] nums, int low, int high, int k) {
        int p = placingPivot(nums, low, high);
        if (p == nums.length - k) {
            return nums[p];
        }
        else if (p < (nums.length - k)) {
            return recurse(nums, p+1, high, k);
        }
        return recurse(nums, low, p-1, k);
    }

    private int placingPivot(int[] nums, int low, int high) {
        int pivot = (low + high) / 2;
        int lowerBoundary = low;
        int temp = nums[high];
        nums[high] = nums[pivot];
        nums[pivot] = temp;
        pivot = high;
        for (int i=low; i<high; i++) {
            if (nums[i] < nums[pivot]) {
                temp = nums[i];
                nums[i] = nums[lowerBoundary];
                nums[lowerBoundary] = temp;
                lowerBoundary++;
            }
        }
        temp = nums[lowerBoundary];
        nums[lowerBoundary] = nums[pivot];
        nums[pivot] = temp;
        return lowerBoundary;
    }
}
