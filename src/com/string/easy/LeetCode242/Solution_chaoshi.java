package com.string.easy.LeetCode242;

/**
 * @author GONG
 * @version 创建时间：2020-10-13 下午4:09:15
 * @类说明: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词 输入: s = "anagram", t =
 *       "nagaram" 输出: true （假设字符串只包含小写字母）
 */
public class Solution_chaoshi {

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		String str1 = getSortedString(s);
		String str2 = getSortedString(t);
		// System.out.println("打印一下两个排好序的字符串：");
		// System.out.println("s:" + str1);
		// System.out.println("t:" + str2);
		if (str1.equals(str2))
			return true;
		else
			return false;
	}

	public static String getSortedString(String s) {
		char[] arr = s.toCharArray();
		char temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		String s = "anagram", t = "nagaram";
		Solution_chaoshi solution = new Solution_chaoshi();
		boolean ans = solution.isAnagram(s, t);
		System.out.println("这两个字符串是字母异位词吗？   " + ans);
	}
}
