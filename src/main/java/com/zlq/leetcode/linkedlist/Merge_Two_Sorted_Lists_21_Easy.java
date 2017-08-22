package com.zlq.leetcode.linkedlist;

/**
 * Created by liqing.zhan on 2017/8/22.
 */
public class Merge_Two_Sorted_Lists_21_Easy {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            ListNode head = null;
            if (l1.val <= l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }

            ListNode prev = head;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            if (l1 != null) {
                prev.next = l1;
            }
            if (l2 != null) {
                prev.next = l2;
            }

            return head;
        }
    }
}
