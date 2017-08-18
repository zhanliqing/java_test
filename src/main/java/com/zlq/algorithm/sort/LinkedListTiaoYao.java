package com.zlq.algorithm.sort;

/**
 * 前后跳跃输出
 * <p>
 * l1->l2->l3->l4->l5
 * 变幻成
 * <p>
 * l1->l5->l2->l4-L3
 * <p>
 * Created by liqing.zhan on 2017/8/17.
 */
public class LinkedListTiaoYao {
    static class Node {
        Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        String value;
        Node next;

        public String toString() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        Node head = init(500);
        Node mid = getMidNode(head);
        Node f = head;
        Node m = revert(mid.next);
        mid.next = null;
        while (m != null) {
            Node n = f.next;
            f.next = m;
            m = m.next;
            f.next.next = n;
            f = f.next.next;
        }
        check(head);

    }

    /**
     * 初始化
     *
     * @param c
     * @return
     */
    private static Node init(int c) {
        int i = 2;
        Node head = new Node("1", null);
        Node node = head;
        while (i <= c) {
            Node next = new Node(String.valueOf(i++), null);
            node.next = next;
            node = next;
        }
        return head;
    }

    /**
     * 打印输出
     *
     * @param head
     */
    private static void check(Node head) {
        while (head != null) {
            System.out.print(String.format("%s\t", head));
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    private static Node revert(Node head) {
        if (head == null) {
            return null;
        }
        Node next = head.next;
        head.next = null;

        while (next != null) {
            Node n1 = next.next;
            next.next = head;
            head = next;
            next = n1;
        }
        return head;
    }

    /**
     * 交换链表的两个节点的next节点
     *
     * @param first
     * @param second
     */
    private static void swap(Node first, Node second) {
        if (first == second.next) {
            swapNeighber(second, first);
        } else if (first.next == second) {
            swapNeighber(first, second);
        } else {
            Node sn = first.next.next;
            first.next.next = second.next.next;
            second.next.next = sn;
            sn = second.next;
            second.next = first.next;
            first.next = sn;
        }
    }

    /**
     * 交换相邻的两个链表节点的next节点
     *
     * @param first
     * @param second
     */
    private static void swapNeighber(Node first, Node second) {
        Node sn = second.next;
        first.next = second.next;
        second.next = second.next.next;
        sn.next = second;

    }

    /**
     * 获取中间节点
     *
     * @param head
     * @return
     */
    private static Node getMidNode(Node head) {
        if (head == null) {
            return null;
        }
        Node h1 = head;
        Node h2 = head;

        while (true) {
            if (h2 == null || h2.next == null || h2.next.next == null) {
                return h1;
            }
            h1 = h1.next;
            h2 = h2.next;
            if (h2 != null) {
                h2 = h2.next;
            } else {
                return h1;
            }
        }
    }
}
