package cn.swordOffer.baidu;

import cn.swordOffer.num12.RoadOnRec;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;
import java.util.function.LongFunction;

public class KuaiPai {

    public static void main(String[] args) {
        int[] arr = {10, 6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int k = 2;
        int ans = qS(arr, 0, arr.length - 1, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("==============");
        System.out.println(ans);
    }

    private static int qS(int[] arr, int left, int right, int k) {
        if (left > right) return -1;
        int i = left, j = right;
        int pivot = arr[left];
        while (i != j) {
            while (arr[j] <= pivot && i < j) j--;
            while (arr[i] >= pivot && i < j) i++;
            if (i < j) swap(arr, i, j);
        }
        arr[left] = arr[i];
        arr[i] = pivot;
        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return qS(arr, left, i - 1, k);
        } else {
            return qS(arr, i + 1, right, k);

        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}