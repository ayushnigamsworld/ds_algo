package Array;

public class MaxProductSubarray {

    public static void main(String[] args) {
        int[] arr = {2, -3, 2, -4, -5, 1 };
        System.out.println(maxProductSubarr(arr));
    }

    public static int maxProductSubarr(int[] arr) {
        int max_ending_here = arr[0];

        // min negative product ending
        // at the current position
        int min_ending_here = arr[0];

        // Initialize overall max product
        int max_so_far = arr[0];
    /* Traverse through the array.
    the maximum product subarray ending at an index
    will be the maximum of the element itself,
    the product of element and max product ending previously
    and the min product ending previously. */
        for (int i = 1; i < arr.length; i++)
        {
            int temp = Math.max(arr[i],
                    Math.max(arr[i] * max_ending_here, arr[i] * min_ending_here));
            min_ending_here = Math.min(arr[i],
                    Math.min(arr[i] * max_ending_here, arr[i] * min_ending_here));
            max_ending_here = temp;
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
}
