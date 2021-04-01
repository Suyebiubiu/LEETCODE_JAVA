package cn.swordOffer.num14_2;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/18 14:06
 * 数据太大了，及时用long，然后随时模大数
 */
public class RopeCup {
    public static void main(String[] args) {
        System.out.println(new RopeCup().cuttingRope(127));
    }

    public int cuttingRope(int n) {
        long ans = 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        while (n > 4) {
            ans = ans * 3 % 1000000007;
            n = n - 3;
        }
        ans = ans * n % 1000000007;
        return (int) ans;
    }
}
