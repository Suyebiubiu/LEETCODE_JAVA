package com.string.easy.LeetCode242;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author GONG
 * @version 创建时间：2020-10-13 下午5:16:40 类说明
 */
public class Solution {
	/*
	 * 方法1.排序  将两个字符串分别排序，最后比较，一样就是true，反之false
	 * 执行用时：3 ms, 在所有 Java 提交中击败了86.33%的用户 ; 内存消耗：38.9 MB, 在所有 Java 提交中击败了63.19%的用户
	 */
	public boolean isAnagram1(String s, String t) {
		if (s.length() != t.length())
			return false;
		char[] ch1 = s.toCharArray();
		char[] ch2 = t.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		if (Arrays.equals(ch1, ch2))
			return true;
		else
			return false;
	}

	/*
	 * 方法2.计数器  用一个计数器统计第一个字符串26字母出现次数，第二个字符串做减法，如果最后计数器归0，则true，反之false
	 * 执行用时： 6 ms , 在所有 Java 提交中击败了 29.20% 的用户 内存消耗： 38.9 MB , 在所有 Java 提交中击败了74.80%的用户
	 */
	public boolean isAnagram2(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] nums = new int[26];
		for (int i = 0; i < s.length(); i++) {
			nums[s.charAt(i) - 'a']++;
			nums[t.charAt(i) - 'a']--;
		}
		for (int i : nums) {
			if (i != 0)
				return false;
		}
		return true;
	}
	
	/*
	 * 方法3.使用hashmap  用两个hashmap分别统计每个字符串字母出现次数，直接比较，相同为true，反之false
	 * 执行用时：17 ms, 在所有 Java 提交中击败了18.63%的用户内存消耗：39.3 MB, 在所有 Java 提交中击败了21.87%的用户
	 */
	public boolean isAnagram3(String s, String t) {
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		for (char ch : s.toCharArray()) {
			if (map1.containsKey(ch))
				map1.put(ch, map1.get(ch) + 1);
			else
				map1.put(ch, 1);
		}
		for (char ch : t.toCharArray()) {
			if (map2.containsKey(ch))
				map2.put(ch, map2.get(ch) + 1);
			else
				map2.put(ch, 1);
		}
		if (map1.equals(map2))
			return true;
		else
			return false;
	}
	/*
	 * 主函数
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "anagram", t = "nagaram";
		boolean ans1 = solution.isAnagram1(s, t);
		boolean ans2 = solution.isAnagram2(s, t);
		boolean ans3 = solution.isAnagram3(s, t);
		System.out.println("方法一的结果：" + ans1);
		System.out.println("方法二的结果：" + ans2);
		System.out.println("方法三的结果：" + ans3);
	}
}
