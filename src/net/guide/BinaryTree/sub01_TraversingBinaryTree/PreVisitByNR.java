package net.guide.BinaryTree.sub01_TraversingBinaryTree;

import javafx.scene.transform.Rotate;

import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/11 16:56
 * 题目：前序遍历非递归实现
 */
public class PreVisitByNR {
    /**
     * 利用一个栈
     * 根进去，弹出来，右进左进
     */
    public static void preOrderByNR(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            //栈非空
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.value);
                if (root.right != null) stack.push(root.right);
                if (root.left != null) stack.push(root.left);
            }
        }
    }
}
