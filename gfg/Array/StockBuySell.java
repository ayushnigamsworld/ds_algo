package Array;

import java.util.ArrayList;

public class StockBuySell {

    public static void main(String aa[]) {
        int input[] = new int[]{23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
        int inp[] = new int[]{4, 2, 2, 2, 4};
        stockBuySell(inp, inp.length);
    }

    private static void stockBuySell(int arr[], int n) {

        // Your code here
        ArrayList<Integer> buy = new ArrayList<>();
        ArrayList<Integer> sell = new ArrayList<>();
        if (arr[0] < arr[1]) {
            buy.add(arr[0]);
        }
        for (int i=1; i<n-1; i++) {
            if (arr[i-1] >= arr[i] && arr[i] < arr[i+1]) {
                buy.add(i);
            }
            if (arr[i-1] < arr[i] && arr[i+1] <= arr[i]) {
                sell.add(i);
            }
        }
        if (arr[n-2] < arr[n-1]) {
            sell.add(n-1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< buy.size();i++) {
            sb.append("(");
            sb.append(Integer.toString(buy.get(i)));
            sb.append(" ");
            sb.append(Integer.toString(sell.get(i)));
            sb.append(")");
        }
        if (sb.length() == 0) {
            System.out.print("No Profit");
        }
        System.out.print(sb.toString().trim());
    }
}
