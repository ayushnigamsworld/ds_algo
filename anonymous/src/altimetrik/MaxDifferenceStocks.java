package altimetrik;

public class MaxDifferenceStocks {

    public static void main(String[] args) {
        int[] ar = new int[] {7, 5, 3, 1};
        System.out.println(maxDiff(ar, 4));
    }

    private static int maxDiff(int arr[], int arr_size)
    {
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];
        int i;
        for (i = 1; i < arr_size; i++)
        {
            if (arr[i] - min_element > max_diff)
                max_diff = arr[i] - min_element;
            if (arr[i] < min_element)
                min_element = arr[i];
        }
        return max_diff;
    }
}
