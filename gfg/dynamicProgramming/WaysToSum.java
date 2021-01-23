package dynamicProgramming;

public class WaysToSum {

    public static void main(String[] args) {
        System.out.println(countWays(5));
    }

    static int countWays(int n){

        int ways[] = new int[n+1];
        ways[0] = 1;
        //Using a coin, one at a time
        for(int j=1; j<=n-1; j++)//Using a coin, one at a time
        {
            for(int i=1;i<=n;i++)
            {
                if(i>=j)//Since it makes no sense to create change for value smaller than coin's denomination
                {
                    ways[i] += ways[i-j];
                }
            }
        }

        return (int)(ways[n]%(Math.pow(10, 9) + 7));
    }
}
