package net.guide.BinaryTree.sub01_TraversingBinaryTree;

import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/11 16:56
 * 题目：后序遍历非递归实现
 */
public class PostVisitByNRBy1Stack {
    /**
     * 非递归
     * 两个栈
     * 设置两个变量 h 和 c。在整个流程中
     * printedNode 代表最近一次弹出并打印的节点，
     * topNode 代表 stack 的栈顶节点
     * 初始时 h 为头节点，c 为 null。
     */
    public static void postOrderByNRBy1Stack(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node topNode = null;
            //栈非空的话
            while (!stack.isEmpty()) {
                topNode = stack.peek();
                if (topNode.left != null && head != topNode.left && head != topNode.right) {
                    stack.push(topNode.left);
                } else if (topNode.right != null && head != topNode.right) {
                    stack.push(topNode.right);
                } else {
                    System.out.println(stack.pop().value);
                    head = topNode;
                }
            }
        }
    }
}
