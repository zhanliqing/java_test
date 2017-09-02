package com.zlq.leetcode.linkedlist;

/**
 * Created by liqing.zhan on 2017/8/22.
 */
public class Remove_Nth_Node_From_End_of_List_19_medium {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode prev = head;
        prev.next = new ListNode(2);
        prev = prev.next;
        prev.next = new ListNode(3);
        prev = prev.next;
        prev.next = new ListNode(4);
        prev = prev.next;
        prev.next = new ListNode(5);

        head = Solution.removeNthFromEnd(head, 1);
        Add_Two_Numbers_2_medium.print(head);
    }

    static class Solution {
        public static ListNode removeNthFromEnd1(ListNode head, int n) {
            ListNode h1 = head, h2 = head;
            while (n-- > 0) h2 = h2.next;
            if (h2 == null) return head.next;  // The head need to be removed, do it.
            h2 = h2.next;

            while (h2 != null) {
                h1 = h1.next;
                h2 = h2.next;
            }
            h1.next = h1.next.next;   // the one after the h1 need to be removed
            return head;
        }

        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode start = new ListNode(0);
            ListNode slow = start, fast = start;
            slow.next = head;

            //Move fast in front so that the gap between slow and fast becomes n
            for (int i = 1; i <= n + 1; i++) {
                fast = fast.next;
            }
            //Move fast to the end, maintaining the gap
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            //Skip the desired node
            slow.next = slow.next.next;
            return start.next;
        }
    }
}

