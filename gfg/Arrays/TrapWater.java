package Arrays;

public class TrapWater {
    public static void main(String aa[]) {
        int input[] = {1, 2, 3, 2, 0, 4, 2, 3, 4}; // Ans: 7
        System.out.println(maximumWaterTrap(input));
    }
    private static int maximumWaterTrap(int arr[]) {
        int result = 0;
        for (int i=1; i < arr.length -1; i++) {
            int maxOnLeft = findMaxBetween(arr, 0, i-1);
            int maxOnRight = findMaxBetween(arr, i+1, arr.length-1);
            int heightExpected = Math.min(maxOnLeft, maxOnRight);
            if (heightExpected > arr[i]) {
                result += heightExpected - arr[i];
            }
        }
        return result;
    }
    private static int findMaxBetween(int arr[], int start, int end) {
        int highest = Integer.MIN_VALUE;
        for (int i=start; i<= end; i++) {
            if (highest < arr[i]) {
                highest = arr[i];
            }
        }
        return highest;
    }
}
