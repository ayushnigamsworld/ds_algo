package Coderbyte;

//Java program to find circular tour for a truck

public class GasStation
{
    // A petrol pump has petrol and d to next petrol pump
    static class Pair
    {
        int petrol;
        int d;

        // constructor
        public Pair(int petrol, int d)
        {
            this.petrol = petrol;
            this.d = d;
        }
    }

    // The function returns starting point if there is a possible solution,
    // otherwise returns -1
    static int printTour(Pair input[], int n)
    {
        int start = 0;
        int end = 1;
        int current = input[start].petrol - input[start].d;

        // If current amount of petrol in truck becomes less than 0, then
        // remove the starting petrol pump from tour
        while(end != start || current < 0)
        {

            // If current amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
            while(current < 0 && start != end)
            {
                // Remove starting petrol pump. Change start
                current -= input[start].petrol - input[start].d;
                start = (start + 1) % n;

                // If 0 is being considered as start again, then there is no
                // possible solution
                if(start == 0)
                    return -1;
            }
            // Add a petrol pump to current tour
            current += input[end].petrol - input[end].d;

            end = (end + 1)%n;
        }

        // Return starting point
        return start;
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {

        Pair[] arr = {new Pair(6, 4),
                new Pair(3, 6),
                new Pair(7, 3)};

        int start = printTour(arr, arr.length);

        System.out.println(start == -1 ? "No Solution" : "Start = " + start);

    }

}
//This code is contributed by Sumit Ghosh
