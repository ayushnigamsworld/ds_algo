package gupshup;

import java.util.*;

/**
 * Find kth element after merging n arrays and being sorted.
 *
 *   10,20,30
 *   5, 15
 *   1, 9, 11, 18
 *
 *   k = 6
 *
 *   1 5 9 10 11 15 18 20 30
 *
 *   output : 15
 *
 */
public class KthAfterMergingSorted {

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
        KthAfterMergingSorted kthAfterMergingSorted = new KthAfterMergingSorted();
        int res = kthAfterMergingSorted.findKth(ls, 6);
        System.out.println(res);
    }

    public int findKth(List<List<Integer>> inp, int k) {
        for (List<Integer> current: inp) {
            Collections.sort(current);
        }

        Queue<Model> minHeap = new PriorityQueue<>(Comparator.comparingInt(inp1 -> inp1.currentElement));

        int index = 0;
        for (List<Integer> current: inp) {
            minHeap.offer(new Model(current.get(0), index, 0));
            index++;
        }

        Model minModel = null;
        while (k > 0) {
            minModel = minHeap.poll();
            k--;
            if (k == 0) {
                break;
            }
            Model modifiedModel = new Model(inp.get(minModel.currentArr).get(minModel.currentIndexInArr + 1),
                    minModel.currentArr, minModel.currentIndexInArr + 1);
            minHeap.offer(modifiedModel);
        }
        return minModel.currentElement;
    }

    class Model {

        int currentElement;
        int currentArr;
        int currentIndexInArr;
        Model(int c, int currentArr, int currentIndexInArr) {
            this.currentElement = c;
            this.currentArr = currentArr;
            this.currentIndexInArr = currentIndexInArr;
        }


    }
}
