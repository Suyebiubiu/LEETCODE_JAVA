package com.array.easy.LeetCode1431;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GMT
 * @version 1.0
 * @data 2020年10月13日
 */
public class Solution {
	/*
	 * 方法：先求出数组中最大值，然后分别与extraCandies相加，与最大值进行比较 执行用时：1 ms, 在所有 Java
	 * 提交中击败了99.88%的用户内存消耗：38 MB, 在所有 Java 提交中击败了100.00%的用户
	 */
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		// 找出candies中最大的值,没有类似max的方法
		int maxValue = candies[0];
		for (int i = 1; i < candies.length; i++) {
			if (candies[i] > maxValue)
				maxValue = candies[i];
		}
		List<Boolean> list = new ArrayList<Boolean>();
		for (int i = 0; i < candies.length; i++) {
			if (extraCandies + candies[i] >= maxValue)
				list.add(true);
			else
				list.add(false);
		}
		return list;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] candies = { 2, 4, 5, 9 };
		int extraCandies = 6;
		List<Boolean> ans = solution.kidsWithCandies(candies, extraCandies);
		System.out.println(ans);
	}
}
