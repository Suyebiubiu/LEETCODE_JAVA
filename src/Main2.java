import java.util.Scanner;

/**
 * @version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nDis = new int[n];
        int[] mDis = new int[m];
        for (int i = 0; i < n; i++) {
            nDis[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            mDis[i] = scanner.nextInt();
        }
        int max = getMaxScore(n, m, nDis, mDis);
        System.out.println(max);
    }

    private static int getMaxScore(int n, int m, int[] nDis, int[] mDis) {
        int maxValue = Integer.MIN_VALUE;
        for (int d = 1; d <= 1000; d++) {
            int nScore = getScore(n, nDis, d);
            int mScore = getScore(m, mDis, d);
            int value = mScore - nScore;
            if (value > maxValue)
                maxValue = value;
        }
        return maxValue;
    }

    private static int getScore(int n, int[] nDis, int d) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (nDis[i] <= d) {
                sum += 1;
            } else {
                sum += 2;
            }
        }
        return sum;
    }
}
