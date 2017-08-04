package com.zlq.algorithm.sort;

/**
 * Created by liqing.zhan on 2017/8/3.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        Node head = new Node(0, null);
        head = init(head);
        print(head);
        System.out.println();
        print(reverse(head));
    }

    public static Node reverse(Node head) {
        if (head == null) {
            return head;
        }

        Node h = head.next;
        head.next = null;

        while (h != null) {
            Node tmp = h.next;
            h.next = head;
            head = h;
            h = tmp;
        }
        return head;
    }

    public static void print(Node head) {
        if (head == null) {
            return;
        }
        Node h = head;
        while (h != null) {
            System.out.print(h.getValue() + ",");
            h = h.getNext();
        }
    }

    public static Node init(Node head) {
        Node h = head;
        for (int i = 1; i < 10; i++) {
            Node node = new Node(i, null);
            h.next = node;
            h = node;
        }
        return head;
    }
}


class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}