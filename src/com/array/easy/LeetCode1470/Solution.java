package com.array.easy.LeetCode1470;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author GMT
 * @version 1.0
 * @create 2020-10-1818:07
 */
public class Solution {

    /* 方法一：
     * 比较直接的想法是，分别按顺序取出这些数字放到list中，最后返回一个数组
     * 执行用时：3 ms, 在所有 Java 提交中击败了5.51%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了95.28%的用户
     * */
    public int[] shuffle1(int[] nums, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length / 2; i++) {
            list.add(nums[i]);
            list.add(nums[i + n]);
        }
        int ans[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        return ans;
    }

    /*
     * 方法二：
     * 因为本身我们已经有了一个nums数组，我们不必创建新的数组，但是好像执行用时和内存消耗没啥变化
     * 执行用时：3 ms, 在所有 Java 提交中击败了5.51%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了92.35%的用户
     * */
    public int[] shuffle2(int[] nums, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length / 2; i++) {
            list.add(nums[i]);
            list.add(nums[i + n]);
        }
        for (int i = 0; i < list.size(); i++)
            nums[i] = list.get(i);
        return nums;
    }

    /*
     * 方法三：直接用数组，不用list，答案是对的，只是这个时候传进去的nums数组已经发生了变化
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了99.52%的用户
     * */
    public int[] shuffle3(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {1, 3, 5, 2, 4, 6};
        int n = nums.length / 2;
        int ans1[] = solution.shuffle1(nums, n);
        System.out.print("经过方法一，ans1：");
        System.out.println(Arrays.toString(ans1));
        System.out.print("经过方法一，nums：");
        System.out.println(Arrays.toString(nums));
        int ans2[] = solution.shuffle2(nums, n);
        System.out.print("经过方法二，ans2：");
        System.out.println(Arrays.toString(ans2));
        System.out.print("经过方法二，nums：");
        // 事实上，函数对nums修改值，nums数组已经发生了变化
        // 参数传值：基本数据类型传递的是副本，引用数据类型跟着变化
        System.out.println(Arrays.toString(nums));
        int ans3[] = solution.shuffle3(nums, n);
        System.out.print("经过方法三，ans3：");
        System.out.println(Arrays.toString(ans3));
        System.out.print("经过方法三，nums：");
        System.out.println(Arrays.toString(nums));
    }
}
