package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Minimum number of jumps
 Given an array of integers where each element represents the max number of steps that can be made forward from that element. The task is to find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.

 Input:
 The first line contains an integer T, depicting total number of test cases.  Then following T lines contains a number n denoting the size of the array. Next line contains the sequence of integers a1, a2, ..., an.

 Output:
 For each testcase, in a new line, print the minimum number of jumps. If answer is not possible print "-1"(without quotes).

 Constraints:
 1 ≤ T ≤ 100
 1 ≤ N ≤ 107
 0 <= ai <= 107

 Example:
 Input:
 2
 11
 1 3 5 8 9 2 6 7 6 8 9
 6
 1 4 3 2 6 7
 Output:
 3
 2

 Explanation:
 Testcase 1: First jump from 1st element, and we jump to 2nd element with value 3. Now, from here we jump to 5h element with value 9. and from here we will jump to last.

 */
public class MakeJump {
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        for (int T = in.nextInt(); T-->0;) {
            int n = in.nextInt();
            int jumpSize[] = new int[n];
            for (int i=0; i<n; i++)
                jumpSize[i] = in.nextInt();
            int[] minJumpNeeded = new int[n];
            Arrays.fill(minJumpNeeded, Integer.MAX_VALUE);
            minJumpNeeded[0] = 0;
            for (int targetToReach=1; targetToReach<n; targetToReach++) {
                for (int jumpFrom= 0; jumpFrom < targetToReach;  jumpFrom++) {
                    if ( jumpSize[jumpFrom] + jumpFrom >= targetToReach) {
                        if (minJumpNeeded[jumpFrom] != Integer.MAX_VALUE)
                            minJumpNeeded[targetToReach] = Math.min(1+ minJumpNeeded[jumpFrom], minJumpNeeded[targetToReach]);
                    }
                }
            }
            System.out.println(minJumpNeeded[n-1]);
        }


        /*
        {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int numOfTestCases = t;

        for(int p = 0;p<numOfTestCases;p++){
            int n = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] input= new int[n];
            for(int i = 0;i<n;i++){
                input[i] = Integer.parseInt(arrStr[i]);
            }

            int[] dp = new int[n];
            Array.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i=1; i<n; i++) {
                for (int j=0; j<i; j++) {
                    if ((j+ input[j]) >= i ) {
                        if (dp[j] != Integer.MAX_VALUE) {
                            dp[i] = Math.min(1+ dp[j], dp[i]);
                        }
                    }
                }
            }
            if (dp[n-1] != Integer.MAX_VALUE)
                System.out.println(dp[n-1]);
            else
                System.out.println("-1");
        }
	 }
         */
    }
}
