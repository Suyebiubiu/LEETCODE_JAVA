package cn.swordOffer.baidu;

import java.util.Arrays;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/29 9:38
 */
public class ZhengFuPaiXu {
    // 处理完之后，负数在前，保持原来顺序
    public static int[] specialSort(int[] arr, int n) {
        int tmp = 0, num = 0;//num用来标记当前处理到第几个数
        for (int i = 0; i < n && num < n; ++i, ++num) {
            if (arr[i] < 0) continue;
            else {
                tmp = arr[i];
                for (int j = i; j < n - 1; j++)
                    arr[j] = arr[j + 1];
                arr[n - 1] = tmp;
                i--;//arr[i]为正数的时候，后面的数会前移，这是arr[i]变为arr[i+1],为了不漏掉数，所以i不能变。--一次和++一次保证i不变
                //但是这有可能会导致死循环。所以用num来标记已处理数的个数。
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, -5, 9, -12, 15};
        int n = arr.length;
        int[] ints = specialSort(arr, n);
        System.out.println(Arrays.toString(ints));
    }
}

