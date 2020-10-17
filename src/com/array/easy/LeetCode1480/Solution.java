package com.array.easy.LeetCode1480;

import java.util.Arrays;

/**
 * @author GMT
 * @version 1.0
 * @create 2020-10-1719:42
 */
public class Solution {
    /*
     *方法一：开辟一个新数组
     * ans[i] = ans[i - 1] + nums[i];
     *执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     *内存消耗：38.4 MB, 在所有 Java 提交中击败了99.03%的用户
     */
    public int[] runningSum1(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] + nums[i];
        }
        return ans;
    }

    /*
     *方法二：直接在原数组上进行操作
     *执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     *内存消耗:38.5 MB, 在所有 Java 提交中击败了98.13%的用户
     */
    public int[] runningSum2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 4, 5, 5};
        int[] ans1 = solution.runningSum1(nums);
        int[] ans2 = solution.runningSum2(nums);
        System.out.println(Arrays.toString(ans1));
        System.out.println(Arrays.toString(ans2));
    }
}
