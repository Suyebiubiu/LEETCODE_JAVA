package net.guide.recursionAndDP.sub03_changeMoney;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/10 16:56
 * 题目：给定数据arr，arr中都是正数且不重复
 * arr中每个值代表一种面值的货币，每种货币可以有任意张
 * 再给你一个整数target，代表要兑换的钱数
 * 求组成target最少的货币数？
 * <p>
 * 样例：5 2 3   target=20
 * 结果: 4张5元的
 */
public class ChangeMoney {
    public static void main(String[] args) {
        int[] moneyArr = {5, 2, 3};
        int target = 10000;
        int ans = minCoins2(moneyArr, target);
        System.out.println(ans);
    }

    /**
     * 暴力递归
     * 使用递归
     * 每一种面值都尝试不同的张数
     */
    private static int getMinNum1(int[] moneyArr, int target) {
        //判断边界条件
        if (moneyArr == null || moneyArr.length == 0 || target < 0) return -1;
        //从数组第一个数开始遍历，最后一个是剩下没换的钱数
        return process(moneyArr, 0, target);
    }

    private static int process(int[] moneyArr, int i, int rest) {
        //已经没有面值可以考虑了
        //此时如果剩余钱为0，返回0张，如果剩余钱不为0，返回-1
        if (i == moneyArr.length) {
            return rest == 0 ? 0 : -1;
        }
        //将结果初始为-1，还没有找到有效的解
        int resCount = -1;
        //尝试使用当前面值的钱moneyArr[i]
        //使用0张，1张，2张，k张，最大为rest张
        for (int curCount = 0; curCount * moneyArr[i] <= rest; curCount++) {
            //使用了count张当前面值的钱，剩下的钱rest = rest-count*arr[i]
            int nextCount = process(moneyArr, i + 1, rest - curCount * moneyArr[i]);
            if (nextCount != -1) {//说明剩余钱数为0
                if (resCount == -1) //初始值
                    resCount = nextCount + curCount;
                else
                    resCount = Math.min(resCount, nextCount + curCount);
            }
        }
        return resCount;
    }

    /**
     * 时间复杂度为 O(N×aim)
     * 动态规划
     * 如果使用 2 张 5 元，0 张 2 元，那么后续的过程是 process(arr,2,90)；
     * 如果使用 0 张 5 元，5 张 2元，后续的过程还是 process(arr,2,90)。
     * 这个状态的返回值肯定是一样的，说明一个状态最终的返回值与怎么达到这个状态的过程无关。
     * 这个特征叫做无后效性
     */
    public static int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0)  return -1;
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int col = 1; col <= aim; col++)
            dp[N][col] = -1;// 设置最后一排的值，除 dp[N][0]为 0 外，其他都是-1
        for (int i = N - 1; i >= 0; i--) { // 从底往上计算每一行
            for (int rest = 0; rest <= aim; rest++) { // 每一行都从左往右
                dp[i][rest] = -1; // 初始时先设置 dp[i][rest]的值无效
                if (dp[i + 1][rest] != -1) { // 下面的值如果有效
                    dp[i][rest] = dp[i + 1][rest]; // 先设置成下面的值
                }
                if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
                    if (dp[i][rest] == -1) { // 如果之前下面的值无效
                        dp[i][rest] = dp[i][rest - arr[i]] + 1;
                    } else { // 说明下面和左边的值都有效，取最小的
                        dp[i][rest] = Math.min(dp[i][rest],
                                dp[i][rest - arr[i]] + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }
    /**
     * 动态规划的空间压缩
     * */


}
