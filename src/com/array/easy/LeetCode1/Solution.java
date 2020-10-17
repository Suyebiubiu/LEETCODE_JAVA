/**
 * 
 */
package com.array.easy.LeetCode1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GMT
 * @data 2020年10月13日
 * @version 1.0
 */
public class Solution {
	/*
	 * 方法一：暴力：直接双层for循环 小技巧是怎么返回一个一维数组：new int[] { i, j }和new int[0] 
	 * 执行用时：71 ms, 在所有Java 提交中击败了29.06%的用户 内存消耗： 38.2 MB , 在所有 Java 提交中击败了99.95%的的用户
	 */
	public int[] twoSum1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target)
					return new int[] { i, j };
			}
		}
		return new int[0];
	}

	/*
	 *方法二：借助于hashmap，key和value逆向思维考虑
	 * 执行用时： 3 ms , 在所有 Java 提交中击败了 73.01% 的用户   内存消耗： 38.2 MB , 在所有 Java 提交中击败了99.95%的用户
	 */
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hashmap.containsKey(target - nums[i])) {
				return new int[] { hashmap.get(target - nums[i]), i };
			}
			hashmap.put(nums[i], i);
		}

		return new int[0];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 2, 4, 5, 9 };
		int target = 6;
		int[] ans1 = solution.twoSum1(nums, target);
		System.out.println("方法一执行结果：" + Arrays.toString(ans1));// 遍历数组
		int[] ans2 = solution.twoSum2(nums, target);
		System.out.println("方法二执行结果：" + Arrays.toString(ans2));// 遍历数组
	}
}
