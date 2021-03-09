package cn.swordOffer.num11;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/9 16:37
 * 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，
 * 我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，
 * 该数组的最小值为1。  
 */
public class RoArrayMinValue {

    /**
     * 比较直接的一个方法
     * （1）当数组只有一个数的时候，直接输出numbers[0]
     * (2) 从头往后遍历数组，当遇到一个数小于前面的数字的时候说明这个数字是最小值
     * （3）假如没有遇到比前面一个数字小的数字，说明这个数组是从头到尾在递增，说明
     * 数组第一个元素就是最小值
     */
    public int minArray1(int[] numbers) {
        int ans = 0;
        if (numbers.length == 1) return numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                ans = numbers[i];
                break;
            } else ans = numbers[0];
        }
        return ans;
    }

    /**
     * 二分查找，因为是两段有序数组
     * 二分查找要求：顺序存储、元素有序
     */
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (numbers[mid] > numbers[high]) {//表示mid前面是有序的，最小值在mid和high之间
                low = mid + 1;//最小值肯定在mid的右侧，所以可以直接mid+1，mid不是最小元素
            } else if (numbers[mid] < numbers[high]) {//表示mid后面是有序的，最小值在low和mid之间
                high = mid;
            } else {//mid对应元素等于high对应元素
                //因为low<high ，所以mid肯定会在high的左侧的，mid有可能等于low
                high--;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(new RoArrayMinValue().minArray(arr));
    }
}
