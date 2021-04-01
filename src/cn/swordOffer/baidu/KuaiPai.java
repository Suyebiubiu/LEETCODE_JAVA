package cn.swordOffer.baidu;

import cn.swordOffer.num12.RoadOnRec;

import java.util.*;
import java.util.function.LongFunction;

public class KuaiPai {

    public static void main(String[] args) {
        int[] arr = {10, 6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        qS(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void qS(int[] arr, int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        int temp = arr[left];
        while (i != j) {
            while (arr[j] >= temp && i < j) j--;
            while (arr[i] <= temp && i < j) i++;
            if (i < j) swap(arr, i, j);
        }
        arr[left] = arr[i];
        arr[i] = temp;
        qS(arr, left, i - 1);
        qS(arr, i + 1, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}