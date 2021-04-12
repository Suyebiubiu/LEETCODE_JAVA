package net.guide.linkedList.sub02_removeLastKthNodeFromLink;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/7 21:41
 * 题目：单链表中删除倒数第K个节点
 */
public class RemoveLastKthNodeFromSingle {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        head = removeLastKthNode(head, 2);
        System.out.println(head.value);
        while (head.next != null) {
            head = head.next;
            System.out.println(head.value);
        }
    }

    private static Node removeLastKthNode(Node head, int k) {
        if (head == null || k < 1) return head;
        Node cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        if (k == 0) return head.next;
        else if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}