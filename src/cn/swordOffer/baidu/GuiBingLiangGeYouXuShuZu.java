package cn.swordOffer.baidu;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.Arrays;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/27 17:24
 */
public class GuiBingLiangGeYouXuShuZu {
    public static void main(String[] args) {
        int[] nums1 = new int[6];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;
        int[] nums2 = new int[3];
        nums2[0] = 7;
        nums2[1] = 8;
        nums2[2] = 9;
        new GuiBingLiangGeYouXuShuZu().merge1(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    //从后往前遍历、双指针法
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        //将nums2中元素从 0 开始 放到nums1的 0 的位置，一共放 p2+1 个
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }


}
