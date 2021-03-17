package cn.swordOffer.num13;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/16 14:29
 * 一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（
 * 不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 */
public class RobotMoveRange {
    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        int count = dfs(m, n, 0, 0, k, visit);
        return count;
    }

    public int dfs(int m, int n, int i, int j, int k, boolean[][] visit) {

        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) return 0;
        if (visit[i][j] == true) return 0;
        if (!getBool(i, j, k)) return 0;
        //可以通过的话
        visit[i][j] = true;
        int count = 1 + dfs(m, n, i + 1, j, k, visit) + dfs(m, n, i, j + 1, k, visit);
        return count;
    }

    public boolean getBool(int m, int n, int k) {
        int sum = 0;
        while (m != 0) {
            sum += m % 10;
            m = m / 10;
        }
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return k >= sum;
    }

}
