package com.zlq.leetcode.linkedlist;

/**
 * Created by liqing.zhan on 2017/8/22.
 */
public class Swap_Nodes_in_Pairs_24_medium {
    public static void main(String[] args) {
        ListNode head = ListNode.init(9);
        head = Solution.swapPairs(head);
        ListNode.print(head);
    }

    static class Solution {
        public static ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode first = head;
            ListNode second = head.next;

            ListNode fprov = first;
            ListNode sprov = second;

            ListNode prov = head.next.next;
            while (true) {
                if (prov == null) {
                    break;
                }
                if (prov != null) {
                    fprov.next = prov;
                    fprov = fprov.next;
                    prov = prov.next;
                }

                if (prov != null) {
                    sprov.next = prov;
                    sprov = sprov.next;
                    prov = prov.next;
                }
            }
            fprov.next = null;
            sprov.next = null;

            head = second;
            ListNode hprov = head;
            second = second.next;

            while (first != null || second != null) {
                if (first != null) {
                    hprov.next = first;
                    hprov = hprov.next;
                    first = first.next;
                }
                if (second != null) {
                    hprov.next = second;
                    hprov = hprov.next;
                    second = second.next;
                }
            }
            return head;
        }
    }
}
