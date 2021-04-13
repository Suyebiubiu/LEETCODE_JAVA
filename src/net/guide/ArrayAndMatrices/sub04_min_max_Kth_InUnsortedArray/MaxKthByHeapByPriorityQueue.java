package net.guide.ArrayAndMatrices.sub04_min_max_Kth_InUnsortedArray;

import java.util.PriorityQueue;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/13 14:32
 * 题目：在一个无序数组中找到第K大的数字
 * 维护动态数据的最大最小值，可以考虑堆
 * 思路：维护一个容量为k的最小值堆，堆顶元素就是第k大数
 */
public class MaxKthByHeapByPriorityQueue {
    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 6, 3, 2};
        int kthLargest = findKthLargest(nums, 3);
        System.out.println(kthLargest);
    }

    /**
     * 时间复杂度：
     * 时间复杂度 O（nlogk）    调整堆：O（logk）
     * 空间复杂度：O（k）
     */
    public static int findKthLargest(int[] nums, int k) {
        //建立一个最小值堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.poll();
    }
}
