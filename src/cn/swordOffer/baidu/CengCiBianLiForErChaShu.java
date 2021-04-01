package cn.swordOffer.baidu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/28 19:22
 * //层次遍历：广度优先搜索
 */
public class CengCiBianLiForErChaShu {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
//        ArrayList<Integer> list = PrintFromTopToBottom(root);
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }
//        System.out.println(list);
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (root == null) {//如果根节点为空的话，直接返回
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();//构造一个队列（使用LinkedList）
        queue.add(root);//首先把根节点添加进去


        while (!queue.isEmpty()) {//如果队列非空的话
            TreeNode nowNode = queue.poll();//拿出队列中头部第一个元素
            resultList.add(nowNode.val);//将拿到的那个元素的值放到结果集合中

            if (nowNode.left != null) {//如果拿到这个节点左边非空的话
                queue.add(nowNode.left);//添加左边节点
            }
            if (nowNode.right != null) {//如果拿到这个节点右边非空的话
                queue.add(nowNode.right);//添加右边节点
            }
        }
        return resultList;//返回这个结果集合
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            resList.add(list);
        }
        return resList;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}