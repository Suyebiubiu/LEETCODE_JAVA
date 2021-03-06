package net.guide.ArrayAndMatrices.sub04_min_max_Kth_InUnsortedArray;

import java.util.Arrays;
import java.util.Random;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/13 14:32
 * 题目：在一个无序数组中找到第K大的数字
 * 方法：基于堆排序的选择方法（维护一个小顶堆）
 */
public class MaxKthByMinHeap {
    public static void main(String[] args) {
        int[] nums = {100, 5, 4, 6, 3, 2};
        int kthLargest = findKthLargest(nums, 3);
        System.out.println(kthLargest);
    }

    /**
     * 时间复杂度为 O(Nlogk)
     * 维护一个小顶堆
     */
    public static int findKthLargest(int[] arr, int k) {
        if (k < 1 || k > arr.length) return -1;
        int[] kHeap = new int[k];
        System.out.println("======建立小顶堆：=======");
        for (int i = 0; i != k; i++) {
            heapInsert(kHeap, arr[i], i);
            System.out.println(Arrays.toString(kHeap));
        }
        System.out.println("=======建堆结束=========");
        System.out.println("===开始调整小顶堆===");
        for (int i = k; i != arr.length; i++) {
            if (arr[i] > kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
            System.out.println(Arrays.toString(kHeap));
        }
        System.out.println("=====end====");
        return kHeap[0];
    }

    private static void heapInsert(int[] kHeap, int value, int index) {
        kHeap[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (kHeap[parent] > kHeap[index]) {
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
        int smallest = index;
        while (left < heapSize) {
            if (arr[left] < arr[index]) {
                smallest = left;
            }
            if (right < heapSize && arr[right] < arr[smallest]) {
                smallest = right;
            }
            if (smallest != index) {
                swap(arr, smallest, index);
            } else {
                break;
            }
            index = smallest;
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
