package medium.linkedlist;

import java.util.List;

public class IntersectionNode {

    /**
     *      4 -> 1
     *             \
     *               -> 8 -> 4 -> 5
     *             /
     *  5 -> 6 -> 1
     *
     *
     */
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode intersNode = new ListNode(8);
        headA.next.next = intersNode;
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersNode;
        headB.next.next.next.next = new ListNode(4);
        headB.next.next.next.next.next = new ListNode(5);
        IntersectionNode i = new IntersectionNode();
        ListNode res = i.findIntersect(headA, headB);
        System.out.println(res.val);
    }

    private ListNode findIntersect(ListNode headA, ListNode headB) {
        ListNode aT = headA;
        int len1 = 0;
        while (aT != null) {
            aT = aT.next;
            len1++;
        }

        ListNode bT = headB;
        int len2 = 0;
        while (bT != null) {
            bT = bT.next;
            len2++;
        }

        ListNode bigger = len1 > len2 ? headA : headB;
        ListNode smaller = len1 > len2 ? headB : headA;

        int diff = Math.abs(len2 - len1);
        while (diff > 0) {
            bigger = bigger.next;
            diff--;
        }

        while (bigger != smaller) {
            bigger = bigger.next;
            smaller = smaller.next;
        }

        return bigger;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
