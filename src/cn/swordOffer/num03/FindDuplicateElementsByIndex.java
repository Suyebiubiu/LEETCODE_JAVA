package cn.swordOffer.num03;

import java.util.jar.JarEntry;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/11/17 10:20
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1
 * 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
 * eg：{2, 3, 1, 0, 2, 5, 3}，返回2或者3
 */
public class FindDuplicateElementsByIndex {

    public int findRepeatNumber(int[] nums) {
        int res = -1;
        int len = nums.length;
        // 判空
        if (len <= 0) return -1;
        for (int i = 0; i < len; i++) {
            //有[0, n-1]范围外的数据
            if (nums[i] < 0 || nums[i] > len - 1) return -1;
            // 如果数组下标不等于数据中的值
            while (nums[i] != i) {
                // 如果相同表示，出现了重复数字
                if (nums[i] == nums[nums[i]])
                    //这个地方一定要return 出去，不然会报错：超出时间限制
                    return nums[i];
                    // 如果不相同，交换两个位置，交换之后，有个位置 nums[i]=i
                else
                    swap(nums, i, nums[i]);
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        FindDuplicateElementsByIndex f = new FindDuplicateElementsByIndex();
        int nums[] = {2, 3, 1, 1, 0, 5, 4};
        int ans = f.findRepeatNumber(nums);
        System.out.println((ans == -1) ? "没有重复数字" : "其中重复数字是" + ans);
    }
}
