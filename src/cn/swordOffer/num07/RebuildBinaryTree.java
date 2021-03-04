package cn.swordOffer.num07;

import cn.swordOffer.util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/12/1 10:24
 * 题目描述：
 * 根据前序遍历和中序遍历结果重建二叉树
 * <p>
 * 为了锻炼，我们首先构造一个二叉树，求前序遍历和中序遍历和后序遍历结果，最后根据前序遍历和中序遍历重建这个二叉树
 */
public class RebuildBinaryTree {
    static ArrayList<Integer> list1 = new ArrayList<>();


    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = new RebuildBinaryTree().buildTree(preorder, inorder);
        //后序遍历 9 15 7 20 3
//        postOrder(root);
        //前序遍历 3 9 20 15 7
        myPreOrder(root);
        //前序遍历，非递归实现
        myPreOrderByStack(root);

    }

    private static void myPreOrderByStack(TreeNode root) {
        //创建一个新的stack栈，存储节点
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            //迭代左子树
            while (root != null) {
                //中左右
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            }
            //左边没有孩子了
            if (!stack.empty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    private static void myPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        if (root.left != null)
            myPreOrder(root.left);
        if (root.right != null)
            myPreOrder(root.right);
    }

    private static void postOrder(TreeNode root) {
        if (root == null) return;
        if (root.left != null)
            postOrder(root.left);
        if (root.right != null)
            postOrder(root.right);
        System.out.println(root.val);
    }


    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        //前序遍历的第一个数字是根节点
        TreeNode root = new TreeNode(preorder[0]);
        //这个二叉树长度
        int len = preorder.length;

        int rootVal = root.val;
        int i;//用i表示中序遍历中根节点的位置
        for (i = 0; i < len; i++) {
            if (inorder[i] == rootVal)
                break;
        }

        //创建左子树
        if (i > 0) {//i=1
            int[] pr = new int[i];
            int[] in = new int[i];
            for (int i1 = 0; i1 < i; i1++) {
                pr[i1] = preorder[i1 + 1];//pr[0]=9
                in[i1] = inorder[i1];//in[0]=9
            }
            root.left = buildTree(pr, in);
        } else {
            root.left = null;
        }

        //创建右子树
        if (len - i - 1 > 0) {
            int[] pr = new int[len - i - 1];
            int[] in = new int[len - i - 1];
            for (int j = i + 1; j < len; j++) {
                pr[j - i - 1] = preorder[j];
                in[j - i - 1] = inorder[j];
            }
            root.right = buildTree(pr, in);
        } else {
            root.right = null;
        }
        return root;
    }
}
