package com.string.easy.LeetCode242;

/**
 * @author GONG
 * @version ����ʱ�䣺2020-10-13 ����4:09:15
 * @��˵��: ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�� ����: s = "anagram", t =
 *       "nagaram" ���: true �������ַ���ֻ����Сд��ĸ��
 */
public class Solution_chaoshi {

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		String str1 = getSortedString(s);
		String str2 = getSortedString(t);
		// System.out.println("��ӡһ�������ź�����ַ�����");
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
		System.out.println("�������ַ�������ĸ��λ����   " + ans);
	}
}
