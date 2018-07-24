package dp;

/**
 * dp.TargetSum494
 * 给定一个数组，通过正负号来使数组中所有元素相加为目标值
 *
 * @author lirongqian
 * @since 2018/04/06
 */
public class TargetSum494 {

    /**
     * 1，2，3，4，5 target=3-》
     * +1-2+3-4+5 = 3
     * P = [1, 3, 5]  N = [2, 4]
     * sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     * 2 * sum(P) = target + sum(nums)
     * 所以当target+sum不满足偶数时或者sum小于target时，即没有可以达到目标的值
     * 所以我们只需要查找P的数量即可
     *
     * @param nums
     * @param s
     * @return
     */
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        // 当sum < s时，返回0，s+sum不为偶数时也直接返回0
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) / 2);
    }

    /**
     * 总种类数等于子集的和
     * @param nums
     * @param s
     * @return
     */
    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                // 0-1背包问题
                dp[i] += dp[i - n];
            }
        }
        return dp[s];
    }

    public static void main(String[] args) {
        System.out.println(new TargetSum494().findTargetSumWays(new int[]{
                1, 2, 3
        }, 2));
    }

}