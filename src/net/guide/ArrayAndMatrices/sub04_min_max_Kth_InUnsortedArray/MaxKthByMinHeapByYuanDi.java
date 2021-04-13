package net.guide.ArrayAndMatrices.sub04_min_max_Kth_InUnsortedArray;

import java.util.Arrays;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/13 14:32
 * 题目：在一个无序数组中找到第K大的数字
 * 方法：基于堆排序的选择方法（维护一个小顶堆）
 */
public class MaxKthByMinHeapByYuanDi {
    public static void main(String[] args) {
        int[] nums = {100, 100, 4, 6, 3, 100};
        int kthLargest = findKthLargest(nums, 3);
        System.out.println(kthLargest);
    }

    /**
     * 时间复杂度为 O(Nlogk)
     * 原地建堆
     * 维护一个小顶堆
     */
    public static int findKthLargest(int[] nums, int k) {
        //前K个元素原地建小顶堆
        buildHeap(nums, k);
        //遍历剩下元素，比堆顶小，跳过；比堆顶大，交换后重新堆化
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < nums[0]) continue;
            swap(nums, i, 0);
            heapify(nums, k, 0);
        }
        //K个元素的小顶堆的堆顶即是第K大元素
        return nums[0];
    }

    /**
     * 建堆函数
     * 从倒数第一个非叶子节点开始堆化，倒数第一个非叶子节点下标为 K/2-1
     */
    public static void buildHeap(int[] a, int k) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            heapify(a, k, i);
        }
    }

    /**
     * 堆化函数
     * 父节点下标i，左右子节点的下标分别为 2*i+1 和 2*i+2
     */
    public static void heapify(int[] a, int k, int i) {
        //临时变量 minPos 用于存储最小值的下标，先假设父节点最小
        int minPos = i;
        while (true) {
            //和左子节点比较
            if (i * 2 + 1 < k && a[i * 2 + 1] < a[i]) minPos = i * 2 + 1;
            //和右子节点比较
            if (i * 2 + 2 < k && a[i * 2 + 2] < a[minPos]) minPos = i * 2 + 2;
            //如果minPos没有发生变化，说明父节点已经是最小了，直接跳出
            if (minPos == i) break;
            //否则交换
            swap(a, i, minPos);
            //父节点下标进行更新，继续堆化
            i = minPos;
        }
    }

    public static void swap(int[] a, int n, int m) {
        int tmp = a[n];
        a[n] = a[m];
        a[m] = tmp;
    }
}
