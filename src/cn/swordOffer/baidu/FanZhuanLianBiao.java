package cn.swordOffer.baidu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/27 15:13
 */
public class FanZhuanLianBiao {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.setNext(node2);
        node2.setNext(node3);

        int[] ans = new FanZhuanLianBiao().reversePrint(head);
        System.out.println(Arrays.toString(ans));

    }

    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) return null;
        printListFromTailToHead(listNode.next);
        list.add(listNode.val);
        return list;
    }

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int size =stack.size();
        int[] ans = new int[size];
        for (int i = 0; i <size ; i++) {
            ans[i] = stack.pop().val;
        }
        return ans;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}