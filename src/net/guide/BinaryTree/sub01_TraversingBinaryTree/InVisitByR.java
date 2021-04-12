package net.guide.BinaryTree.sub01_TraversingBinaryTree;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/11 16:56
 * 题目：中序遍历：递归实现
 */
public class InVisitByR {
    /**
     * 中序遍历：左 根 右
     */
    public static void inOrderRecur(Node root) {
        if (root == null) return;//判空
        inOrderRecur(root.left);//递归左子树
        System.out.println(root);//打印根节点
        inOrderRecur(root.right);//遍历右子树
    }
}
