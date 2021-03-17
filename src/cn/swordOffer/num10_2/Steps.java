package cn.swordOffer.num10_2;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/9 16:13
 * 问题：青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 0  1
 * 1  1
 * 2  2
 * 3  3   111 12 21
 * 4  5    1111 22 112 211 121
 * n  F(n-1)+F(n-2)
 */
public class Steps {
    /**
     * 直接使用动态规划方法，和num10_1类似
     */
    public int numWays(int n) {
        if (n == 0 || n == 1)
            return 1;
        int a = 1, b = 1, sum = a + b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = sum;
            sum = (a + b) % 1000000007;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Steps().numWays(7));
    }
}
