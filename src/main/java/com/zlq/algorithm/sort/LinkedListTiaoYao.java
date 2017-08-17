package com.zlq.algorithm.sort;

/**
 * 前后跳跃输出
 * <p>
 * l1->l2->l3->l4->l5
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
        Node head = init(5);
        check(head);

        Node mid = getMidNode(head);
        mid = revert(mid);

        Node h1 = head;
        Node m1 = mid;
        while (h1 != mid) {
            Node hn = h1.next;
            h1.next = m1;
            m1 = m1.next;
            h1.next.next = hn;
            h1 = hn;
        }

        System.out.println(getMidNode(head));
//        head = revert(head);
//        check(head);
    }

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

    private static void check(Node head) {
        while (head != null) {
            System.out.print(String.format("%s\t", head));
            head = head.next;
        }
        System.out.println();
    }

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

    private static Node getMidNode(Node head) {
        if (head == null) {
            return null;
        }
        Node h1 = head;
        Node h2 = head;

        while (true) {
            if (h2 == null || h2.next == null) {
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
