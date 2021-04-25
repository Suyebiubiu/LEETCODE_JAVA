import javax.swing.*;
import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {100, 53, 5, 2, 4, 1};
        int[] res = new Solution().GetLeastNumbers_Solution(arr, 4);
        System.out.println(res);
    }

    public int[] GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || k <= 0 || k > input.length) return input;
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = input[i];
            heapInsert(heap, i);
        }

        for (int i = k; i < input.length; i++) {
            if (heap[0] > input[i]) {
                heap[0] = input[i];
                heapify(heap, 0, k);
            }
        }

        return heap;
    }

    public void heapInsert(int[] heap, int index) {
        while (heap[index] > heap[(index - 1) / 2]) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[largest]) largest = left;
            if (right < heapSize && arr[right] > arr[largest]) largest = right;
            if (index != largest) {
                swap(arr, index, largest);
            } else {
                break;
            }
            index = largest;
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}