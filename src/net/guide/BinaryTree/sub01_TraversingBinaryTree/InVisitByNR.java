package net.guide.BinaryTree.sub01_TraversingBinaryTree;

import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/11 16:56
 * 题目：中序遍历非递归实现
 */
public class InVisitByNR {
    /**
     * 利用一个栈
     * 根进，一直将左子树push进去，一直将右子树push进去
     */
    public static void inOrderByNR(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            //栈非空或者head不是null
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
    }

}
