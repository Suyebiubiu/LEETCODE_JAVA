package net.guide.linkedList.sub02_removeLastKthNodeFromLink;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/7 21:41
 * 题目：双链表中删除倒数第K个节点
 */
public class RemoveLastKthNodeFromDouble {
    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        head.next = node2;
        node2.next = node3;
        node2.last = head;
        node3.last = node2;
        DoubleNode ans = removeLastKthNode(head, 2);
        while (ans != null) {
            System.out.println(ans.value);
            ans = ans.next;
        }
    }

    private static DoubleNode removeLastKthNode(DoubleNode head, int k) {
        if (head == null || k < 1) return head;
        DoubleNode cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        if (k == 0) {
            head = head.next;
            head.last = null;
        }
        if (k < 0) {

        }
        return head;
    }
}

class DoubleNode {
    int value;
    DoubleNode last;
    DoubleNode next;
    public DoubleNode(int value) {
        this.value = value;
    }
}