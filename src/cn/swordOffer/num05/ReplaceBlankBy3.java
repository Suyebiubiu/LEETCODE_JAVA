package cn.swordOffer.num05;

/**
 * @author GMT
 * @version 1.0
 * @create 2021-03-0521:25
 * 新建一个数组，长度为原来数组的三倍（最坏的情况就是所有的字符均是空格）
 * 从前往后插入
 */
public class ReplaceBlankBy3 {


    public static void main(String[] args) {
        String beforeStr = " ab g gt r ";
        System.out.println("解法一：使用StringBuffer， 替换前：" + beforeStr + " 替换后：" + ReplaceBlankBy3.replaceBlank(beforeStr));
    }

    private static String replaceBlank(String beforeStr) {
        int beforeStr_len = beforeStr.length();

        char[] newStr_ch = new char[beforeStr_len * 3];
        int size = 0;

        for (int i = 0; i < beforeStr_len; i++) {
            char beforeStr_ch = beforeStr.charAt(i);
            if(beforeStr_ch==' '){
                newStr_ch[size++]='%';
                newStr_ch[size++] = '2';
                newStr_ch[size++]='0';
            }else{
                newStr_ch[size++] = beforeStr_ch;
            }
        }
        return new String(newStr_ch,0,size);
    }
}
