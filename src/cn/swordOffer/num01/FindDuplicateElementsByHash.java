package cn.swordOffer.num01;

import java.util.HashSet;

/**
 * @author GMT
 * @version 1.0
 * @create 2021-03-0321:05
 * 题目描述：
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1
 * 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
 * eg：{2, 3, 1, 0, 2, 5, 3}，返回2或者3
 */
public class FindDuplicateElementsByHash {
    /*
     * 查找重复数字
     */
    public int getDuplicate(int[] nums) {
        int res = -1;
        if (nums.length<=0) return res;

        //创建一个Hashset
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                res = num;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindDuplicateElementsByHash f = new FindDuplicateElementsByHash();
        int nums[] = {2, 3, 1, 0, 2, 5, 3};
        int ans = f.getDuplicate(nums);
        System.out.println((ans == -1) ? "没有重复数字" : "其中重复数字是" + ans);
    }

}
