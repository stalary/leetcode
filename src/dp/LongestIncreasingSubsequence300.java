package dp;

import java.util.*;

/**
 * dp.LongestIncreasingSubsequence300
 * 最长递增序列
 *
 * @author lirongqian
 * @since 2018/04/12
 */
public class LongestIncreasingSubsequence300 {

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence300().lengthOfLIS(new int[]{
                11, 12, 13, 14, 15, 6, 7, 8, 101, 18
        }));
        List<Integer> list = new LinkedList<>();
        list.add(list.get(2), 3);
    }

    /**
     * 在之前查找x，如果找不到，则返回最接近的左边元素，如果是当前元素，则数量增加
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int x : nums) {
            // 通过二分来维护一个low数组
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}