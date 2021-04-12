package net.guide.ArrayAndMatrices.sub04_min_max_Kth_InUnsortedArray;

import java.util.Arrays;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/10 21:33
 * 题目：给定一个无序的整型数组 arr，找到其中最小的 k 个数
 * 直接排序O(NlogN)。
 * 本题要求实现时间复杂度为 O(Nlogk)和 O(N)的方法。
 */
public class MinKInUnsortedArrayByHeap {
    public static void main(String[] args) {
        int[] arr = {2, 2, 6, 12, 9, 3, 1};
        getMinKNumsByHeap(arr, 3);
    }

    /**
     * 时间复杂度为 O(Nlogk)
     * 维护一个大顶堆
     */
    public static int[] getMinKNumsByHeap(int[] arr, int k) {
        if (k < 1 || k > arr.length) return arr;
        int[] kHeap = new int[k];
        System.out.println("======建立大顶堆：=======");
        for (int i = 0; i != k; i++) {
            heapInsert(kHeap, arr[i], i);
            System.out.println(Arrays.toString(kHeap));
        }
        System.out.println("=======建堆结束=========");
        System.out.println("===开始调整大顶堆===");
        for (int i = k; i != arr.length; i++) {
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
            System.out.println(Arrays.toString(kHeap));
        }
        System.out.println("=====end====");
        return kHeap;
    }

    private static void heapInsert(int[] kHeap, int value, int index) {
        kHeap[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (kHeap[parent] < kHeap[index]) {
                swap(kHeap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
