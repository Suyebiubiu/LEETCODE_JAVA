package net.guide.BinaryTree.sub01_TraversingBinaryTree;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/11 16:56
 * 题目：后序遍历：递归实现
 */
public class PostVisitByR {
    /**
     * 后序遍历：左右根
     */
    public static void postOrderRecur(Node root) {
        if (root == null) return;//判空
        postOrderRecur(root.left);//递归左子树
        postOrderRecur(root.right);//递归右子树
        System.out.println(root.value);//打印根节点
    }
}
