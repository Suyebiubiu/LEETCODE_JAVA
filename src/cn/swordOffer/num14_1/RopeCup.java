package cn.swordOffer.num14_1;

/**
 * @author GMT
 * @version 1.0
 * @create 2021-03-179:31
 */
public class RopeCup {
    /**
     * 动态规划
     * 解析：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/jian-zhi-offer-14-i-jian-sheng-zi-huan-s-xopj/
     */
    public int cuttingRope2(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int k = 3; k <= n; k++) {//求dp[k]
            // 绳子隔取第一段，第一段为1没有意义，绳子的第一段以2开始
            for (int i = 2; i <= k; i++)
                dp[k] = Math.max(Math.max(dp[k], i * dp[k - i]), i * (k - i));
        }
        return dp[n];
    }

    /**
     * 贪心算法：尽可能多分几个长度为3的线段
     */
    public int cuttingRope(int n) {
        int ans = 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        while (n > 4) {//最后返回时乘以小于等于4的最后一小段
            ans *= 3;
            n = n - 3;
        }
        ans = ans * n;//最后返回时乘以小于等于4的最后一小段
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new RopeCup().cuttingRope(10));
    }

}
