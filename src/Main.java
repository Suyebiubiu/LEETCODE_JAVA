import java.util.Scanner;

public class Main {
    static int N = 1000;
    static int n, ans, max;
    static int[] s1 = new int[N + 5], s2 = new int[N + 5];
    static int[][] dp = new int[N + 5][N + 5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            s1[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            s2[i] = sc.nextInt();
        }
        lcs();
        for (int i = 2; i <= n; i++) {
            ans = max(ans, dp[n][i]);
        }
        System.out.println(ans);
    }

    static void lcs() {
        for (int i = 1; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s2[j] < s1[i] && max < dp[i - 1][j]) {
                    max = dp[i - 1][j];
                }
                if (s1[i] == s2[j]) {
                    dp[i][j] = max + 1;
                }
            }
        }
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }
}
