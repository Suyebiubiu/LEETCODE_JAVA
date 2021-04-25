package net.guide.ArrayAndMatrices.sub06_halfMajor;

import com.sun.org.apache.bcel.internal.generic.IFLE;

import javax.sound.midi.MidiChannel;
import java.time.temporal.ValueRange;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/14 14:24
 * 题目：在有序数组中找到是否有某一个数出现次数超过一半，有的话返回true，没有的话返回
 */
public class HalfMajorInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2};
        boolean ans = halfMajor(arr);
        System.out.println(ans);
    }

    /**
     * arr 为待查找数据
     */
    private static boolean halfMajor(int[] arr) {
        int len = arr.length;//arr数组长度
        int value = arr[len / 2];//中间值
        boolean isLeft = true;//先查找左侧
        //查找 左侧数组中，value出现位置最小的索引
        int preIndex = BinarySearch(arr, len, value, 0, len / 2 - 1, isLeft);
        if (preIndex == -1) preIndex = len / 2;//如果没有出现value的话，证明左侧都比value小，让preindex = value出现的位置即可
        // 查找右侧数组中，value出现位置最大的索引
        isLeft = false;//开始查找右侧
        int lastIndex = BinarySearch(arr, len, value, len / 2 + 1, len - 1, isLeft);
        if (lastIndex == -1) lastIndex = len / 2;//如果没有出现value的话，证明右侧都比value大，让preindex = value出现的位置即可

        System.out.println(preIndex + "----" + lastIndex);
        boolean ans = (lastIndex - preIndex + 1) > len / 2 ? true : false;//让两个索引做减法，与数组长度一半进行比较
        return ans;
    }

    /**
     * arr是待查找数组
     * len 是数组长度
     * value 是数组中间值
     * value将arr分为左右两个部分
     * begin是 左侧或者右侧数组的左边界
     * end 是左侧或者右侧数组的右边界
     * isleft用来标记 是左侧数组还是右侧数组，true表示左侧，false表示右侧数组
     */
    private static int BinarySearch(int[] arr, int len, int value, int begin, int end, boolean isLeft) {
        if (isLeft) {//是左边区域找最左侧
            while (begin <= end) {
                int mid = (begin + end) >> 1;
                if (arr[mid] < value) {// 1 [1] 1【2】
                    if (begin == len / 2 - 1) return -1;
                    begin = mid + 1;
                } else if (arr[mid] == value) {
                    end = mid - 1;
                }
            }
            return begin;
        } else {//右侧区域，找最右侧
            while (begin <= end) {
                int mid = (begin + end) >> 1;
                if (arr[mid] > value) {
                    if (end == len / 2 + 1) return -1;
                    end = mid - 1;
                } else if (arr[mid] == value) {
                    begin = mid + 1;
                }
            }
            return end;
        }
    }
}
