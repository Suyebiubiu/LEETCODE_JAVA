package net.guide.recursionAndDP.sub01_fib;

import java.util.LinkedList;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/10 13:40
 * 题目描述：给定整数N，返回fib的第N项
 * 问题补充：
 * 给定整数N代表台阶数，一次能走两阶或者一阶，有多少种走法？
 */
public class Fib {
    public static void main(String[] args) {
        int n = 4;
        int ans = getFib4(n);
        System.out.println(ans);
        new LinkedList<>();
    }

    /**
     * 1 2 3 5 8 13 ......
     * O(2^n)
     */
    public static int getFib1(int n) {
        if (n < 1) throw new RuntimeException("数字应该是大于0的整数");
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else {
            return getFib1(n - 1) + getFib1(n - 2);
        }
    }

    /**
     * 时间：O(N)
     * 空间：O(N)
     */
    public static int getFib2(int n) {
        if (n < 1) throw new RuntimeException("数字应该是大于0的整数");
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        if (n > 2) dp[n] = dp[n - 1] + dp[n - 2];
        return dp[n];
    }

    /**
     * 时间：O(N)
     * 空间：O(1)
     */
    public static int getFib3(int n) {
        if (n < 1) throw new RuntimeException("数字应该是大于0的整数");
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1, b = 2;
        int sum = a + b;
        for (int i = 3; i < n; i++) {
            a = b;
            b = sum;
            sum = a + b;
        }
        return sum;
    }

    /**
     * O(logN)
     * 矩阵乘法
     * F(n)=F(n-1)+F(n-2)，是一个二阶递推数列，
     * 一定可以用矩阵乘法的形式表示，且状态矩阵为 2×2 的矩阵
     */
    public static int getFib4(int n) {
        if (n < 1) throw new RuntimeException("数字应该是大于0的整数");
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[][] m = {{1, 1}, {1, 0}};
        int[][] ans = matPower(m, n - 2);
//        for (int i = 0; i < ans.length; i++) {
//            System.out.println(Arrays.toString(ans[i]));
//        }
        return 2*ans[0][0] + ans[1][0] ;
    }

    /**
     * 求一个矩阵m的p次方
     */
    private static int[][] matPower(int[][] m, int p) {
        int[][] ans = new int[m.length][m[0].length];
        for (int i = 0; i < ans.length; i++) {
            ans[i][i] = 1;//单位矩阵
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0)//表示最后一位是1，不是0
                ans = mulMat(ans, tmp);
            tmp = mulMat(tmp, tmp);
        }
        return ans;
    }

    /**
     * 计算两个矩阵相乘
     */
    private static int[][] mulMat(int[][] mat1, int[][] mat2) {
        int[][] res = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                //mat1[0].length == mat2.length
                for (int k = 0; k < mat1[0].length; k++) {
                    res[i][j] += (mat1[i][k] * mat2[k][j]);
                }
            }
        }
        return res;
    }
}
