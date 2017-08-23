package com.zlq.leetcode.linkedlist;

/**
 * Created by liqing.zhan on 2017/8/22.
 */
public class Remove_Duplicates_from_Sorted_List_83_easy {
    public static void main(String[] args) {
        ListNode head = ListNode.init(10);
        head.val = 1;
        head.next.val = 2;
        head.next.next.val = 2;
        head = Solution.deleteDuplicates1(head);
        ListNode.print(head);
    }

    static class Solution {
        public static ListNode deleteDuplicates1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prev = head;
            while (prev != null) {
                if (prev.next != null && prev.val == prev.next.val) {
                    prev.next = prev.next.next;
                } else {
                    prev = prev.next;
                }
            }
            return head;
        }

        public static ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode node = head.next;
            ListNode prev = head;
            prev.next = null;

            while (node != null) {
                if (prev.val != node.val) {
                    prev.next = node;
                    prev = prev.next;
                    node = node.next;
                    prev.next = null;
                } else {
                    node = node.next;
                }

            }
            return head;
        }
    }
}
