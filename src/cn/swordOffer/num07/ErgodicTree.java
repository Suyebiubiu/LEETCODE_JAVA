package cn.swordOffer.num07;

import cn.swordOffer.util.TreeNode;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/12/1 14:08
 */
public class ErgodicTree {
    /**
     * 1-1.二叉树的前序遍历:递归实现方式
     * 遍历顺序：根左右
     * 遍历方式：递归+循环两种方式
     */
    private static void preErgodicByRecursion(TreeNode root) {
        // 判空
        if (root == null) return;
        System.out.print(root.val + " ");
        preErgodicByRecursion(root.left);
        preErgodicByRecursion(root.right);
    }

    /**
     * 1-2.二叉树的前序遍历:非递归实现方式（循环方式）
     * 遍历顺序：根左右
     * 遍历方式：递归+循环两种方式
     */
    private static void preErgodicByCycle(TreeNode root) {


    }


    public static void main(String[] args) {
        // 构造一个二叉树
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node3.right = node4;
        node5.left = node6;
        node5.right = node7;
        node7.left = node8;

        // 1-1. 前序遍历(递归实现)
        preErgodicByRecursion(node1);//递归实现
        // 1-2. 前序遍历(非递归实现)
        preErgodicByCycle(node1);//非递归实现


        // 2.中序遍历
//        int[] midOrder = midErgodic(node1);

        // 3.后序遍历
//        int[] afterOrder = afterErgodic(node1);
    }
}
