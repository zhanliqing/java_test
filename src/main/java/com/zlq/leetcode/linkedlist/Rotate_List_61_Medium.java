package com.zlq.leetcode.linkedlist;

/**
 * Created by liqing.zhan on 2017/8/22.
 */
public class Rotate_List_61_Medium {
    public static void main(String[] args) {
        ListNode head = ListNode.init(10);
        ListNode.print(head);
        head = Solution.rotateRight(head, 11);
        ListNode.print(head);
    }

    static class Solution {
        public static ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            int len = 1;
            ListNode node = head.next;

            ListNode lastEnd = head;
            while (node != null) {
                lastEnd = lastEnd.next;
                node = node.next;
                len++;
            }

            k = k % len;
            if (k == 0) {
                return head;
            }
            ListNode fast = head;
            ListNode slow = head;

            while (k-- >= 0) {
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            lastEnd.next = head;
            head = slow.next;
            slow.next = null;
            return head;
        }
    }
}
