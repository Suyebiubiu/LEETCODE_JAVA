import java.util.Scanner;

/**
 * @version 1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        int ans = getMaxDis(n, str);
        System.out.println(ans);
    }

    private static int getMaxDis(int n, String str) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i == 2) {
                int count_0 = getCountO(str.substring(0, 2));
//                System.out.println(count_0);
                if (count_0 == 0 || count_0 == 2) dp[2] = 2;
                else dp[2] = 0;
            } else {
                dp[i] = Math.max(dp[i - 3], dp[i - 1] + getValue(str, i - 1));
            }
        }
        return dp[n];
    }

    private static int getValue(String str, int index) {
        int value = 0;
        int count0 = getCountO(str.substring(0,index+1));
        int count1 = str.length() - count0;
        if (count0 >= count1) {
            if (str.charAt(index) == '0') {
                value += 1;
            } else {
                value -= 1;
            }

        } else {//1多
            if (str.charAt(index) == '0') {
                value -= 1;
            } else {
                value += 1;
            }
        }
//        System.out.println(value);
        return value;
    }

    private static int getCountO(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                count++;
        }
        return count;
    }


}
