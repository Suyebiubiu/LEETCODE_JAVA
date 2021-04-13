package net.guide.ArrayAndMatrices.sub04_min_max_Kth_InUnsortedArray;

import java.util.Random;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/13 14:32
 * 题目：在一个无序数组中找到第K小的数字
 * 快速选择算法：适用于在确定量的情况下寻找第k小数
 * 如果是动态数据流，只能使用堆排序算法
 */
public class MinKthByQuickSelect {
    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 6, 3, 2};
        int kthLargest = findKthSmallest(nums, 2);
        System.out.println(kthLargest);
    }

    /**
     * 1：第1小 索引为0
     */
    public static int findKthSmallest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    /**
     * index指的是排序后应该的索引
     * 比如3 2 1 5 6 4 求第4小数4 索引为 3 = k-1
     */
    private static int quickSelect(int[] nums, int left, int right, int index) {
        int indexOfBenchMark = randomPartition(nums, left, right);
        if (indexOfBenchMark == index) {
            return nums[indexOfBenchMark];
        } else {
            return indexOfBenchMark < index ?
                    quickSelect(nums, indexOfBenchMark + 1, right, index) :
                    quickSelect(nums, left, indexOfBenchMark - 1, index);
        }
    }

    private static int randomPartition(int[] nums, int left, int right) {
        Random rand = new Random();
        int pivot = rand.nextInt(right - left + 1) + left;
        //方便比较除了基准之外所有元素
        //我们将基准放到最后面
        swap(nums, pivot, right);
        return partition(nums, left, right);
    }

    /**
     * 将小于基准的放到基准的左侧，大于基准的放到基准的右侧
     * 返回基准的索引
     */
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right],
                i = left - 1;
        for (int j = left; j < right; ++j) {
            if (nums[j] <= pivot) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
