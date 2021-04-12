package net.guide.linkedList.sub01_commonPartFor2SortedLink;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/7 17:40
 * 题目：给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
 * 2 3 4
 * 2 2 4
 * 输出：2 4
 */
public class CommonPartFor2SortedLink {
    public static void main(String[] args) {
        Node head11 = new Node(2);
        Node head12 = new Node(3);
        Node head13 = new Node(4);
        head11.next = head12;
        head12.next = head13;
        Node head21 = new Node(2);
        Node head22 = new Node(2);
        Node head23 = new Node(4);
        head21.next = head22;
        head22.next = head23;
        getCommonPart(head11, head21);
    }

    private static void getCommonPart(Node head11, Node head21) {
        while (head11 != null && head21 != null) {
            if (head11.value < head21.value) head11 = head11.next;
            else if (head11.value > head21.value) head21 = head21.next;
            else {//如果相等的话
                System.out.println(head11.value);
                head11 = head11.next;
                head21 = head21.next;
            }
        }
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
