package com.string.easy.LeetCode344;

import java.awt.print.Printable;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/10/22 11:31
 */
public class Solution {
    /*
     *执行用时：1 ms, 在所有 Java 提交中击败了99.99%的用户
     *内存消耗：45.1 MB, 在所有 Java 提交中击败了96.06%的用户
     * */
    public void reverseString(char[] s) {
        int begin = 0;
        char temp;
        int end = s.length - 1;
        while (begin < end) {
            temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("输入：" + String.valueOf(input));
        solution.reverseString(input);
        System.out.println("输出：" + String.valueOf(input));
    }
}
