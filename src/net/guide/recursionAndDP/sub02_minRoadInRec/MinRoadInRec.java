package net.guide.recursionAndDP.sub02_minRoadInRec;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/10 16:12
 * 题目：给一个矩阵m*n，从左上角只能向右或者向下走，最后到达右下角位置
 * 路径上所有数字累加即为路径和，返回所有路径中最小的路径和。
 */
public class MinRoadInRec {
    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(minPathSum1(m));
    }

    /**
     * 时间复杂度为 O(M×N)，
     * dp 矩阵的大小为 M×N，所以额外空间复杂度为 O(M×N)
     */
    public static int minPathSum1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) return 0;
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    /**
     * 动态规划的空间压缩
     * 时间复杂度依然是 O(M×N)，
     * 额外空间复杂度可以从 O(M×N)减小至 O(min{M,N})
     * 通过一个数组滚动更新的方式无疑节省了大量的空间
     */
    public int minPathSum2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int more = Math.max(m.length, m[0].length); // 行数与列数较大的那个为 more
        int less = Math.min(m.length, m[0].length); // 行数与列数较小的那个为 less
        boolean rowmore = more == m.length; // 行数是不是大于或等于列数
        //行数大于列数的话，rowmore为true
        int[] arr = new int[less]; // 辅助数组的长度仅为行数与列数中的最小值
        arr[0] = m[0][0];
        for (int i = 1; i < less; i++) {
            //如果行数大于列数的话，从上往下翻滚数组
            //如果列数大于行数的话，从左往右翻滚数组
            arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
            for (int j = 1; j < less; j++) {
                arr[j] = Math.min(arr[j - 1], arr[j])
                        + (rowmore ? m[i][j] : m[j][i]);
            }
        }
        return arr[less - 1];
    }
}
