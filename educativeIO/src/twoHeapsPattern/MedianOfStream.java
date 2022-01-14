package twoHeapsPattern;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 1. insertNum(3)
 2. insertNum(1)
 3. findMedian() -> output: 2
 4. insertNum(5)
 5. findMedian() -> output: 3
 6. insertNum(4)
 7. findMedian() -> output: 3.5

 Max        Min
  |          |

 3
 3 - 1
 1          3
 1          3 - 5
 3 - 1      5

 3 - 1      4 - 5



 */
public class MedianOfStream {

    private Queue<Integer> leftSideMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private Queue<Integer> rightSideMinHeap = new PriorityQueue<>();
    private int count;

    public static void main(String[] args) {
        MedianOfStream medianOfStream = new MedianOfStream();
        medianOfStream.add(3);
        medianOfStream.add(1);
        System.out.println(medianOfStream.findMedian());
        medianOfStream.add(5);
        System.out.println(medianOfStream.findMedian());
        medianOfStream.add(4);
        System.out.println(medianOfStream.findMedian());
    }

    public void add(int inp) {
        count++;
        if (leftSideMaxHeap.size() == 0) {
            leftSideMaxHeap.offer(inp);
        } else {
            if (inp <= leftSideMaxHeap.peek()) {
                leftSideMaxHeap.offer(inp);
            } else {
                rightSideMinHeap.offer(inp);
            }
        }
        balance();
    }

    public int findMedian() {
        if (count % 2 == 0) {
            return (leftSideMaxHeap.peek() + rightSideMinHeap.peek())/2;
        }
        return leftSideMaxHeap.peek();
    }

    private void balance() {
        int lSize = leftSideMaxHeap.size();
        int rSize = rightSideMinHeap.size();
        if (lSize != rSize && count != 1) {
            if (count % 2 == 0 || (count % 2 != 0 && lSize - rSize != 1 )) {
                if (lSize > rSize) {
                    rightSideMinHeap.offer(leftSideMaxHeap.poll());
                } else {
                    leftSideMaxHeap.offer(rightSideMinHeap.poll());
                }
            }
        }
    }
}
