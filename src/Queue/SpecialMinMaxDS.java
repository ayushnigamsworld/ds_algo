package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class SpecialMinMaxDS {

    Deque<Integer> deque = new LinkedList<>();
    public void insertMin(int a) {
        deque.offerFirst(a);
    }

    public void insertMax(int b) {
        deque.offerLast(b);
    }

    public int getMin() {
        return deque.peekFirst();
    }

    public int getMax() {
        return deque.peekLast();
    }

    public int extractMin() {
        return deque.pollFirst();
    }

    public int extractMax() {
        return deque.pollLast();
    }
}

class UseMinMaxDS {
    public static void main(String[] args) {
        SpecialMinMaxDS specialMinMaxDS = new SpecialMinMaxDS();
        specialMinMaxDS.insertMax(25);
        specialMinMaxDS.insertMax(35);
        specialMinMaxDS.insertMin(20);
        specialMinMaxDS.insertMax(40);
        specialMinMaxDS.insertMin(15);
        System.out.println(specialMinMaxDS.getMin());
        System.out.println(specialMinMaxDS.getMax());
        System.out.println(specialMinMaxDS.extractMax());
        System.out.println(specialMinMaxDS.extractMin());
        specialMinMaxDS.insertMax(45);
        specialMinMaxDS.insertMin(10);
        System.out.println(specialMinMaxDS.getMin());
        System.out.println(specialMinMaxDS.getMax());
        System.out.println(specialMinMaxDS.extractMax());
        System.out.println(specialMinMaxDS.extractMin());
    }
}
