package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *   10,20,30
 *   5, 15
 *   1, 9, 11, 18
 *
 */
public class MergeKSortedArr {
    public static void main(String[] args) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(10);
        temp.add(20);
        temp.add(30);
        ls.add(new ArrayList<>(temp));
        temp = new ArrayList<>();
        temp.add(5);
        temp.add(15);
        ls.add(temp);
        temp = new ArrayList<>();
        temp.add(1);
        temp.add(9);
        temp.add(11);
        temp.add(18);
        ls.add(temp);
        System.out.println(mergeKSortedArr(ls, 3));
    }

    /**
     * Using MinHeap which maintains Size of Max K elements,
     * Thus O(nKlogK)
     * @param inp
     * @param k
     * @return
     */
    private static List<Integer> mergeKSortedArr(List<List<Integer>> inp, int k) {
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<k; i++) {
            priorityQueue.offer(new Element(inp.get(i).get(0), i, 0));
        }
        while (!priorityQueue.isEmpty()) {
            Element a = priorityQueue.poll();
            result.add(a.data);
            int outerIndex = a.arr;
            int innerIndex = a.index + 1;
            if (inp.get(outerIndex).size() != innerIndex) {
                priorityQueue.offer(new Element(inp.get(outerIndex).get(innerIndex), outerIndex, innerIndex));
            }
        }
        return result;
    }
}

class Element implements Comparable<Element>{
    Integer data;
    Integer arr;
    Integer index;
    Element(int data, int arr, int index) {
        this.data = data;
        this.arr = arr;
        this.index = index;
    }


    @Override
    public int compareTo(Element o) {
        if (data == o.data) {
            return 0;
        } else if (data > o.data) {
            return 1;
        } else {
            return -1;
        }
    }
}
