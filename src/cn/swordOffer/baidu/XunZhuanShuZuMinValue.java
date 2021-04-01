package cn.swordOffer.baidu;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/27 18:26
 */
public class XunZhuanShuZuMinValue {
    //利用快排的思想，有序数组中的查找
    private int minArrayGuanFang(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
