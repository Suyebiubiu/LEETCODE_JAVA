package cn.swordOffer.num01;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/11/17 10:20
 * <p>
 * 给定一个数组，查找其是否有重复元素，如果有，任意返回一个重复元素
 * eg：{2, 3, 1, 0, 2, 5, 3}，返回2或者3
 */
public class FindDuplicateElementsByBinarySearch {

    public int getDuplicate(int[] nums) {
        // 判空
        int len = nums.length;
        if (len <= 0) return -1;
        
        // 使用二分法
        int start = 0;
        int end = len - 1;
        while (end >= start) {
            int middle = start + (end - start) / 2;
            // 判断在某个区间内，出现的数字个数，比如在0-2区间，如果出现了4个数字，那么肯定是出现了重复数字了
            int countByRange = countRange(nums, len, start, middle);
            // 求到了最后，指针指向了同一个位置
            if (start == end) {
                if (countByRange > 1) return start;
                else break;
            }
            // 缩小区间，如果前面区间满足条件，end前移，如果前面不满足条件，start后移
            if (countByRange > (middle - start + 1)) end = middle;
            else start = middle + 1;
        }
        return -1;
    }

    // 查找start 到 end 这个区间内，数组中出现的数字一共有多少个？
    private int countRange(int[] nums, int len, int start, int end) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= start && nums[i] <= end)
                ++count;
        }
        return count;
    }


    public static void main(String[] args) {
        FindDuplicateElementsByBinarySearch f = new FindDuplicateElementsByBinarySearch();
        int nums[] = {2, 3, 1, 0, 2, 5, 3};
        int ans = f.getDuplicate(nums);
        System.out.println((ans == -1) ? "没有重复数字" : "其中重复数字是" + ans);
    }
}
