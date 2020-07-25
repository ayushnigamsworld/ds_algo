package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class FirstCircularTourPetrol {

    public static void main(String[] args) {
        System.out.println(usingdeque(new int[]{4, 8, 7, 4}, new int[] {6, 5, 3, 5}));
    }

    private static int firstPetrolPump(int petrol[], int dist[]) {
        for (int i=0; i<petrol.length; i++) {
            int end = i;
            int availablePetrol = 0;
            int cnt = 0;
            while (cnt != petrol.length) {
                availablePetrol += petrol[end];
                if (availablePetrol < dist[end]) {
                    break;
                } else {
                    availablePetrol -= dist[end];
                }
                end = (end + 1)% petrol.length;
                cnt++;
            }
            if (cnt == petrol.length) {
                return i+1;
            }
        }
        return -1;
    }

    private static int usingdeque(int petrol[], int dist[]) {
        Deque<Integer> deque = new LinkedList<>();
        int petrolCap = 0;
        int i=0;
        int cnt = 0;
        while (cnt != petrol.length) {
            if (deque.size() == petrol.length) {
                return deque.peekFirst();
            }
            if (petrolCap >=0) {
                deque.addLast(i);
            } else {
                deque.removeFirst();
            }
            petrolCap += petrol[i] - dist[i];
            i = (i+1) % petrol.length;
            cnt++;
        }
        return -1;
    }
}
