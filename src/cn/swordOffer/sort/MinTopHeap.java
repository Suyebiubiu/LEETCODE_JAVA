package cn.swordOffer.sort;

import java.util.Arrays;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/13 21:21
 */
public class MinTopHeap {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 5, 7, 8, 9, 10, 1, 0};
        System.out.println(Arrays.toString(arr));
        heap_sort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * arr表示数组
     * n 表示数组长度
     */
    public static void heap_sort(int[] arr, int n) {
        // 建立一个堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        //排序
        //从最后一个元素开始，交换
        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            //i此时表示这个数组中未排序的长度，维护堆顶元素的性质
            heapify(arr, i, 0);
        }
    }

    /**
     * 维护堆的性质
     * n 是数组长度
     * i 是等待维护节点的下标
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int lson = i * 2 + 1;
        int rson = i * 2 + 2;
        //找出根，左节点，右节点三个节点中最大的下标，存在largest中
        if (lson < n && arr[largest] < arr[lson]) largest = lson;
        if (rson < n && arr[largest] < arr[rson]) largest = rson;
        if (largest != i) {//说明根i不是最大的，我们要进行交换
            swap(arr, largest, i);
            //交换之后，三个中的最大值已经跑到父节点上了
            //i 跑到左孩子或者右孩子上了(largest)
            //递归维护
            heapify(arr, n, largest);//维护这个孩子节点
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}
