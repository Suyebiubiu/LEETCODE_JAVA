package cn.swordOffer.baidu;

import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/14 19:12
 */
public class IsErChaSouSuoShu {
    public static boolean isVilidBST(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            double pre = -Double.MAX_VALUE;
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    if (root.val <= pre) return false;
                    pre = root.val;
                    root = root.right;
                }
            }
        }
        return true;
    }
}
