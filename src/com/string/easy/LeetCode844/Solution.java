package com.string.easy.LeetCode844;

/**
 * @author GMT
 * @version 1.0
 * @create 2020-10-1916:32
 */
public class Solution {
    /* 方法一：借助StringBuffer
     * StringBuffer中有根据位置删除
     * 执行用时：1 ms, 在所有 Java 提交中击败了96.52%的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了99.88%的用户
     * */
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    /*
     * 灵魂方法：
     * stringBuffer.deleteCharAt
     * */
    public String build(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] sch = s.toCharArray();
        for (int i = 0; i < sch.length; i++) {
            if (sch[i] == '#') {
                if (stringBuffer.length() > 0)
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            } else {
                stringBuffer.append(sch[i]);
            }
        }
        return stringBuffer.toString();
    }

    /*
     * 主函数
     * */
    public static void main(String[] args) {
        Solution solution = new Solution();
        String S = "ab##", T = "c#d#";
        boolean ans1 = solution.backspaceCompare(S, T);
        System.out.println(ans1);
    }
}
