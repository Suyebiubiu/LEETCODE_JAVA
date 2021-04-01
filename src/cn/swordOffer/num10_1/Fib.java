package cn.swordOffer.num10_1;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/9 10:52
 * 写一个函数，输入 n ，
 * 求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 答案需要取模 1e9+7（1000000007），
 * 如计算初始结果为：1000000008，请返回 1。
 */
public class Fib {
    /**
     * 利用递归
     */
    //超出时间限制
    public int fib1(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        return (fib1(n - 1) + fib1(n - 2)) % 1000000007;
    }

    /**
     * 创建一个数组存储所有结果
     */
    public int fib2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        int a = 0, b = 1, sum = a + b;
        for (int i = 2; i < n; i++) {
            a = b; b = sum;
            sum = (a + b) % 1000000007;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Fib().fib(n));
    }


}
