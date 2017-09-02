package com.zlq.leetcode.linkedlist;

/**
 * Created by liqing.zhan on 2017/8/22.
 */
public class Add_Two_Numbers_2_medium {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(8);
        ListNode prevl1 = l1;
        prevl1.next = new ListNode(8);
        prevl1 = prevl1.next;
        prevl1.next = new ListNode(8);

        ListNode l2 = new ListNode(9);
        ListNode prevl2 = l2;
        prevl2.next = new ListNode(8);
        prevl2 = prevl2.next;
        prevl2.next = new ListNode(3);

        ListNode head = Solution.addTwoNumbers(l1, l2);
        print(head);
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            if (l1 == null && l2 == null) {
                return null;
            }


            ListNode head = new ListNode((l1.val + l2.val) % 10);
            ListNode prev = head;
            int val = (l1.val + l2.val) / 10;
            l1 = l1.next;
            l2 = l2.next;

            while (l1 != null && l2 != null) {
                ListNode node = new ListNode((l1.val + l2.val + val) % 10);
                val = (l1.val + l2.val + val) / 10;
                prev.next = node;
                prev = node;
                l1 = l1.next;
                l2 = l2.next;
            }

            while (l1 != null) {
                ListNode node = new ListNode((l1.val + val) % 10);
                val = (l1.val + val) / 10;
                prev.next = node;
                prev = node;
                l1 = l1.next;
            }

            while (l2 != null) {
                ListNode node = new ListNode((l2.val + val) % 10);
                val = (l2.val + val) / 10;
                prev.next = node;
                prev = node;
                l2 = l2.next;
            }
            if (val != 0) {
                ListNode node = new ListNode(val);
                prev.next = node;
            }
            return head;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode init(int n) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        for (int i = 1; i <= n; i++) {
            prev.next = new ListNode(i);
            prev = prev.next;
        }
        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}