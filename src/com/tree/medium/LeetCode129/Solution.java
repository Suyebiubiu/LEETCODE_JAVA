package com.tree.medium.LeetCode129;

/**
 * @author GMT
 * @version 1.0
 * @create 2020-10-2922:00
 */
// 结构体构造tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }

    //添加结点
    public TreeNode addNode(TreeNode parentNode, int data, boolean isLeft) {
        //父节点为空，无法添加子节点
        if (parentNode == null)
            throw new RuntimeException("父节点为空，无法添加子节点");
        if (isLeft && parentNode.left != null)
            throw new RuntimeException("左子节点已经存在，添加失败");
        if (!isLeft && parentNode.right != null)
            throw new RuntimeException("右子节点已经存在，添加失败");
        TreeNode newNode = new TreeNode(data);
        if (isLeft) {
            parentNode.left = newNode;
        } else {
            parentNode.right = newNode;
        }
        return newNode;
    }
}

public class Solution {
    /**
     * 方法一：
     * 使用深度优先遍历方法
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了76.76%的用户
     * 时间复杂度：O(n)，其中 n 是二叉树的节点个数。对每个节点访问一次。
     * 空间复杂度：O(n)，其中 n 是二叉树的节点个数。
     * 空间复杂度主要取决于递归调用的栈空间，递归栈的深度等于二叉树的高度，最坏情况下，二叉树的高度等于节点个数，
     *
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 首先定义一个sum为0，遍历从根结点开始计算dfs(root,sum)
     * 当根节点为空返回，否则，将之前和*10加上现在节点的值，赋值给sum变量
     * 当左右为空时候，返回sum，否则返回dfs(left,sum)+dfs(right,sum)
     */
    public int sumNumbers1(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int preSum) {
        if (node == null) {
            return 0;
        }
        int sum = preSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        } else {
            return dfs(node.left, sum) + dfs(node.right, sum);
        }
    }

    /**
     * 方法二：
     * 使用广度优先遍历
     */
    public int sumNumbers2(TreeNode root) {
        return bfs(root, 0);
    }

    private int bfs(TreeNode node, int preSum) {
        if (node == null) {
            return 0;
        }


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.addNode(root, 1, true);//11
        root.addNode(root, 2, false);//12
        Solution solution = new Solution();
        int ans1 = solution.sumNumbers1(root);
        System.out.println(ans1);
        int ans2 = solution.sumNumbers2(root);
        System.out.println(ans2);
    }
}
