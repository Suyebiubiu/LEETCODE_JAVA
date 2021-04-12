import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = scanner.nextInt();
        }
        int index = getHouseIndex(n, k, price);
        System.out.println(index + 1);
    }

    private static int getHouseIndex(int n, int k, int[] price) {
        int ans = -1;
        int count = 0;
        List<Integer> indexFor0 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (price[i] == 0) {//找到了小美的房间
                count++;
                indexFor0.add(i);
            }
            if (count == 1) {//只有一个房间为0
                int left = i;
                int right = i;
                while (left > 0 && right < n) {
                    if (price[--left] <= k) {
                        ans = left;
                        break;
                    }
                    if (price[right++] <= k) {
                        ans = right;
                        break;
                    }
                }
                if (left == 0) {
                    while (right < n) {
                        if (price[right++] <= k) {
                            ans = right;
                            break;
                        }
                    }
                }
                if (right == n - 1) {
                    while (left >= 0) {
                        if (price[--left] <= k) {
                            ans = left;
                            break;
                        }
                    }
                }
            } else {
//                System.out.println("进来了");
                int sizeFor0 = indexFor0.size();
//                System.out.printf("sizeFor0=", sizeFor0);
                int len = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
//                    System.out.println(len);
                    if (price[j] <= k && price[j] != 0) {
                        //j要与所有0的index比较
                        int mylen = 0;
                        for (int i1 = 0; i1 < sizeFor0; i1++) {
                            mylen += Math.abs(indexFor0.get(i1) - j);
                        }
                        if (mylen < len) {
                            len = mylen;
                            ans = j;
                        }
                    }
                }
            }


        }
        return ans;
    }
}
