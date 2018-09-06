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
    }

    /**
     * 在之前查找x，如果找不到，则返回最接近的左边元素，如果是当前元素，则数量增加
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int x : nums) {
            // 通过二分来维护一个low数组，未命中时，返回待插入位置前一个的负数
            int i = Arrays.binarySearch(dp, 0, len, x);
            System.out.println(i);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            // 只有增加新元素时，才增加长度，替换时不改变
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public int lengthOfLIS1(int[] array) {
        // 用于记录当前元素作为最大元素的最长递增序列的长度
        int[] lisLength = new int[array.length];
        // 初始化
        for (int i = 0; i < array.length; i++) {
            lisLength[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                // 当递增并且后移一位大于当前最大长度时，进行替换
                if (array[j] < array[i] && lisLength[j] + 1 > lisLength[i]) {
                    lisLength[i] = lisLength[j] + 1;
                }
                // 得到当前最长递增序列的长度以及该子序列的最末元素的位置
                if (max < lisLength[i]) {
                    max = lisLength[i];
                }
            }
        }
        return max;
    }
}