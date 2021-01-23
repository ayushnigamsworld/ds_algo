package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subarray_Sum {
    public static void main (String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            long n[] = new long[2];
            String st2[] = read.readLine().trim().split("\\s+");
            for(int i = 0; i < 2; i++)
                n[(int)i] = Long.parseLong(st2[(int)i]);

            long total = n[0];
            long sum = n[1];
            long arr[] = new long[(int)total];

            String st[] = read.readLine().trim().split("\\s+");

            for(int i = 0; i < total; i++)
                arr[(int)i] = Long.parseLong(st[(int)i]);

            findSubarraySum(arr, sum);
        }
    }

    public static void findSubarraySum(long arr[], long result) {
        long sum = 0;
        int leftPtr = 0;
        int rightPtr = 0;
        while (leftPtr <= rightPtr && rightPtr <= arr.length) {
            if (sum == result) {
                System.out.println(leftPtr + " " + rightPtr);
                break;
            } else if (sum > result) {
                sum = sum - arr[leftPtr];
                leftPtr++;
            } else if (rightPtr < arr.length){
                sum = sum + arr[rightPtr];
                rightPtr++;
            }
        }
    }
}
