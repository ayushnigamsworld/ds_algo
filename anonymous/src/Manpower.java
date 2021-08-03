public class Manpower {

    public static void main(String[] args) {
        int inp[]=  {-1, 2, 3};
        int i=0, j=1

                ;
        System.out.println(maxSubArraySum(inp, i, j));

    }

    static int maxSubArraySum(int a[], int start, int end)
    {
        int size = a.length;
        int resultMax = Integer.MIN_VALUE, localMax = 0;

        for (int i = start; i <= end; i++)
        {
            localMax = localMax + a[i];
            if (resultMax < localMax)
                resultMax = localMax;
            if (localMax < 0)
                localMax = 0;
        }
        return resultMax;
    }
}
