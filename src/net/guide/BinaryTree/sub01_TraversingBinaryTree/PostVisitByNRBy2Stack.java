package net.guide.BinaryTree.sub01_TraversingBinaryTree;

import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/11 16:56
 * 题目：后序遍历非递归实现
 */
public class PostVisitByNRBy2Stack {
    /**
     * 非递归
     * 两个栈
     * 1．申请一个栈，记为 s1，然后将头节点 head 压入 s1 中。
     * 2．从 s1 中弹出的节点记为 cur，然后依次将 cur 的左孩子节点和右孩子节点压入 s1 中。
     * 3．在整个过程中，每一个从 s1 中弹出的节点都放进 s2 中。
     * 4．不断重复步骤 2 和步骤 3，直到 s1 为空，过程停止。
     * 5．从 s2 中依次弹出节点并打印，打印的顺序就是后序遍历的顺序。
     */
    public static void postOrderByNRBy2Stack(Node head) {
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            //栈非空的话
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) stack1.push(head.left);
                if (head.right != null) stack1.push(head.right);
            }
            //最后的结果都push到了stack2中，直接弹出即可
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().value + " ");
            }
        }
    }
}
