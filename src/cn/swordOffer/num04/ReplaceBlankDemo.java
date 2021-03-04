package cn.swordOffer.num04;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/11/25 12:32
 */
public class ReplaceBlankDemo {
    /**
     * 解法一：使用StringBuffer
     */
    public static String replaceBlank01(String input) {
        // 判空
        if (input == null) return null;
        StringBuffer outBuffer = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') outBuffer.append("%20");
            else outBuffer.append(input.charAt(i));
        }
        return outBuffer.toString();
    }

    /**
     * 解法二：使用StringBuilder
     */
    public static String replaceBlank02(String input) {
        // 判空
        if (input == null) return null;
        StringBuilder outBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') outBuilder.append("%20");
            else outBuilder.append(input.charAt(i));
        }
        return outBuilder.toString();
    }

    /**
     * 解法三：从后往前复制，并且重新创建了一个char数组
     */
    public static String replaceBlank03(String input) {
        // 判空
        if (input == null) return null;

        // 查找字符串中一共有多少个空格
        int blankCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') ++blankCount;
        }

        // 创建一个新的string，利用char[]创建，方便从后往前插入
        int newStringLen = input.length() + blankCount * 2;
        char[] newString = new char[newStringLen];
        int index = newString.length - 1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                newString[index--] = '0';
                newString[index--] = '2';
                newString[index--] = '%';
            } else newString[index--] = input.charAt(i);
        }
        return new String(newString);
    }


    public static void main(String[] args) {
        String beforeStr = " ab g gt r ";
        System.out.println("解法一：使用StringBuffer， 替换前：" + beforeStr + " 替换后：" + ReplaceBlankDemo.replaceBlank01(beforeStr));
        System.out.println("解法二：使用StringBuilder，替换前：" + beforeStr + " 替换后：" + ReplaceBlankDemo.replaceBlank02(beforeStr));
        System.out.println("解法三：从后往前复制，      替换前：" + beforeStr + " 替换后：" + ReplaceBlankDemo.replaceBlank03(beforeStr));
    }

}
