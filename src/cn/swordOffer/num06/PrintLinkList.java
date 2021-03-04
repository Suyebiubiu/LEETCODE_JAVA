package cn.swordOffer.num06;

import cn.swordOffer.util.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/11/27 16:34
 * <p>
 * 题目要求：从尾到头打印链表到每个节点的值
 * 输入一个链表头，从后往前打印每个节点
 */
public class PrintLinkList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        System.out.println("解法一：利用栈输出，反转后：" + PrintLinkList.printListReverse1(node1));
        System.out.println("解法二：递归，反转后：" + PrintLinkList.printListReverse2(node1));
    }

    /**
     * 解法一：利用栈输出
     */
    private static int[] printListReverse1(ListNode node1) {
        // 判空
        if (node1 == null) return null;
        // 创建一个list集合，用来存储最后的结果
        ArrayList<Integer> final_list = new ArrayList<>();
        // 创建一个栈，用来存放节点
        Stack<ListNode> stack = new Stack<>();

        // 将节点按照顺序放在栈中
        ListNode headNode = node1;
        while (headNode != null) {
            stack.push(headNode);//添加节点
            headNode = headNode.next;
        }
        // 通过栈的先进后出的特点，逆序将数据放到list集合中
        while (!stack.empty()) {
            ListNode node = stack.pop();
            final_list.add(node.val);
        }
        return final_list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 解法二：递归(其实底层还是栈)
     */
    private static ArrayList<Integer> printListReverse2(ListNode node1) {
        // 判空
        if (node1 == null) return null;

        // 创建一个list集合，用来存放数据
        ArrayList<Integer> final_list = new ArrayList<>();
        ListNode headNode = node1;
        if (headNode.next != null) {
            final_list = printListReverse2(headNode.next);
        }
        final_list.add(headNode.val);

        return final_list;
    }
}
