package net.guide.ArrayAndMatrices.sub04_min_max_Kth_InUnsortedArray;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/13 14:32
 * 题目：在一个无序数组中找到第K大的数字
 * 快速选择算法：适用于在确定量的情况下寻找第k大数
 * 如果是动态数据流，只能使用堆排序算法
 */
public class MaxKthByQuickSelect {
    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 6, 3, 2};
        int kthLargest = findKthLargest(nums, 3);
        System.out.println(kthLargest);
    }

    /**
     * 3 2 1 5 6 4 求第2大数？
     * 以3位基准第一次排序：2 1 3 5 6 4
     * 做了一个第K大 = 第 size-k+1 小  == 索引是size-k
     * 第1大  = 第 6 小
     * 判断 基准下标 2 和 size-k=4（第5小索引为4）
     * 发现目标值应该在 3 的右侧
     * 快速选择算法就是快速排序算法中基准值计算的过程
     * 随机选择一个基准值，小于基准值的放在左边，大于的放在右边
     * 判断基准值下标和k之间的关系，选择基准值的左侧或者右侧进行下一步操作
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(logn)，递归使用栈空间的空间代价的期望为 O(logn)
     */
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * index指的是排序后应该的索引
     * 比如3 2 1 5 6 4 求第2大数？倒数第5小数
     * index就应该是 6 - 2 = 4 ，索引是4
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
