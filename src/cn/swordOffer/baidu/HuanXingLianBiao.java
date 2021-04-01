package cn.swordOffer.baidu;

import com.sun.media.sound.EmergencySoundbank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/27 17:10
 */
public class HuanXingLianBiao {


    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.next = node2;
        node2.next = node3;
        node3.next = node2;

        boolean bool = new HuanXingLianBiao().hasCycle(head);
        boolean bool2 = new HuanXingLianBiao().hasCycle2(head);
        System.out.println(bool);
        System.out.println(bool2);
    }

    public boolean hasCycle2(Node head) {
        if (head == null || head.next == null) return false;
        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if(fast==null||fast.next==null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycle(Node head) {
        HashSet<Node> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}

class Node {
    int val;
    Node next;

    public Node(int x) {
        val = x;
        next = null;
    }
}
