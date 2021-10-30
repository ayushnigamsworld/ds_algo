package medium.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TripletIncreasingSubsequence {

    public static void main(String[] args) {
        // int arr[] = new int[]{2,1,5,0,4,6};
        int arr[] = new int[]{5,1,5,5,2,5,4};
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        stack.push(arr.length-1);
        for (int i=arr.length-2; i>=0; i--) {
            int current = arr[i];
            while (!stack.isEmpty() && current >= arr[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                map.put(i, stack.peek());
            }
            stack.push(i);
        }

        for (Map.Entry mp: map.entrySet()) {
            System.out.print(arr[(Integer)mp.getKey()] + " -> ");
            System.out.println(arr[(Integer)mp.getValue()]);
        }

        for (int firstIndex=0; firstIndex<=arr.length-3; firstIndex++) {
            int first = arr[firstIndex];
            if (map.containsKey(firstIndex)) {
                int secondIndex = map.get(firstIndex);
                int second = arr[secondIndex];
                if (second > first && map.containsKey(secondIndex)) {
                    int thirdIndex = map.get(secondIndex);
                    int third = arr[thirdIndex];
                    if (third > second) {
                        System.out.println(first + " " + second + " " + third);
                        break;
                    }
                } else {
                    for (secondIndex=firstIndex+1; secondIndex<=arr.length-2; secondIndex++) {
                        second = arr[secondIndex];
                        if (second > first && map.containsKey(secondIndex)) {
                            int thirdIndex = map.get(secondIndex);
                            int third = arr[thirdIndex];
                            if (third > second) {
                                System.out.println(first + " " + second + " " + third);
                                break;
                            }
                        }
                    }
                }
            }
        }

    }
}
