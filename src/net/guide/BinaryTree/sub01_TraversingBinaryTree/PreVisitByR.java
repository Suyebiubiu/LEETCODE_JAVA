package net.guide.BinaryTree.sub01_TraversingBinaryTree;

import javafx.scene.transform.Rotate;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/11 16:56
 * 题目：前序遍历：递归实现
 */
public class PreVisitByR {
    /**
     * 前序遍历：根左右
     */
    public static void preOrderRecur(Node root) {
        if (root == null) return;//判空
        System.out.println(root.value);//打印节点
        preOrderRecur(root.left);//递归左侧
        preOrderRecur(root.right);//递归右侧
    }
}
