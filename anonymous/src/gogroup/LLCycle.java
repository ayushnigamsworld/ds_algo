package gogroup;

import java.io.BufferedReader;

public class LLCycle {
   LLNode head;

   void add(int data) {
       // add into ll
   }

   boolean detectCycle(LLNode head) {
       LLNode slow = head;
       LLNode fast = head;

       while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;

           if (slow == fast) {
               return true;
           }
       }
       return false;
   }
}

class LLNode {
   int data;
   LLNode next;
}


