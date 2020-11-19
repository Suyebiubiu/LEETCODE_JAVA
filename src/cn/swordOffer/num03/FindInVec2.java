package cn.swordOffer.num03;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/11/19 18:45
 * <p>
 * 二维数组中，每一行按照从左到右递增的顺序排序，每一列按照从上到下递增的顺序排序
 * 输入这个二维数组和一个整数
 * 判断数组中是否有这个整数
 */
public class FindInVec2 {

    public static void main(String[] args) {
        FindInVec2 f = new FindInVec2();
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int num = 7;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++)
//                System.out.print(arr[i][j] + " ");
//            System.out.println();
//        }
        boolean b = f.getFindInVec(arr, num);
        System.out.println(b == true ? "找到了" : "没有找到");
    }

    /*
     * 解法二：
     * 二分法
     * 时间复杂度：O(log mn)，空间复杂度：O(1)
     * */
    private boolean getFindInVec(int[][] arr, int num) {
        // 判空条件
        if (arr != null && arr.length == 0) return false;

        int rows = arr.length;//行数
        int columns = arr[0].length;//列数

        boolean find = false;// 用来记录是否找到了该数字，找到了即为true


        return find;
    }
}
