package dp;

public class Knapsack {

    private static int[] weight;
    private static int[] price;
    public static void main(String[] args) {
        weight = new int[] {2, 3, 1, 4};
        price = new int[] {4, 5, 3, 7};
        int capacity = 5;
        System.out.println(knapsack(0, capacity));
    }

    private static int knapsack(int index, int capacity) {

        if (capacity < 0 || index == weight.length) {
            return 0;
        }
        if (weight[index] > capacity) {
            return knapsack(index + 1, capacity);
        }
        int taking = price[index] + knapsack(index + 1, capacity - weight[index]);
        int leaving = knapsack(index + 1, capacity);
        return Math.max(taking, leaving);
    }
}
