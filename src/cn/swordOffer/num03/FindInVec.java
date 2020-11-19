package cn.swordOffer.num03;

import jdk.nashorn.internal.ir.IfNode;

import java.awt.print.Printable;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/11/19 18:45
 * <p>
 * 二维数组中，每一行按照从左到右递增的顺序排序，每一列按照从上到下递增的顺序排序
 * 输入这个二维数组和一个整数
 * 判断数组中是否有这个整数
 */
public class FindInVec {

    public static void main(String[] args) {
        FindInVec f = new FindInVec();
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int num = 1;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++)
//                System.out.print(arr[i][j] + " ");
//            System.out.println();
//        }
        boolean b = f.getFindInVec(arr, num);
        System.out.println(b == true ? "找到了" : "没有找到");
    }

    /*
     * 解法一：
     * 从右上角入手，小了往下找，大了往左找，相等直接返回（同理可以从左下角入手）
     * 这个方法叫做双指针法，行列两个指针
     * 时间复杂度是O(mn)，空间复杂度是O(1)
     * */
    private boolean getFindInVec(int[][] arr, int num) {
        // 判空条件
        if (arr != null && arr.length == 0) return false;

        int rows = arr.length;//行数
        int columns = arr[0].length;//列数

        boolean find = false;// 用来记录是否找到了该数字，找到了即为true

        if (rows > 0 && columns > 0) {
            // 定位到右上角
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0) {//因为行在增加（下移），列在减小（左移）

                // 如果在右上角找到了
                if (arr[row][column] == num) {
                    find = true;
                    break;
                } else if (arr[row][column] > num) {//如果右上角的数字大于我们要查找的数字
                    --column;
                } else {//如果右上角的数字小于我们要查找的数字
                    ++row;
                }
            }
        }
        return find;
    }
}
