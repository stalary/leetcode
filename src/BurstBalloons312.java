/**
 * BurstBalloons312
 * 求扎破气球获得的最大硬币数量
 * @author lirongqian
 * @since 2018/04/07
 */
public class BurstBalloons312 {

    public static void main(String[] args) {
        System.out.println(new BurstBalloons312().maxCoins(new int[]{
                3, 1, 5, 8
        }));
    }

    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) {
            if (x > 0) {
                nums[n++] = x;
            }
        }
        // 将边界设置为1，当两边不存在气球时，默认乘1
        nums[0] = nums[n++] = 1;

        // dp[l][r]表示扎破(l, r)范围内所有气球获得的最大硬币数，不含边界；
        // l与r的跨度k从2开始逐渐增大；
        // 三重循环依次枚举范围跨度k，左边界l，中点m；右边界r = l + k；
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k) {
            for (int l = 0; l < n - k; ++l) {
                int r = l + k;
                for (int m = l + 1; m < r; ++m) {
                    // 求出原最大值和当前成绩之间的最大值
                    dp[l][r] = Math.max(dp[l][r],
                            nums[l] * nums[m] * nums[r] + dp[l][m] + dp[m][r]);
                }
            }
        }
        // 返回从起始位置到末尾的最大值
        return dp[0][n - 1];
    }
}