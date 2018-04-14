package dp;

import java.util.Arrays;

/**
 * dp.PerfectSquares279
 * 判断输入的数需要有多少个平方数组成
 *
 * @author lirongqian
 * @since 2018/04/14
 */
public class PerfectSquares279 {

    public static void main(String[] args) {
        System.out.println(new PerfectSquares279().numSquares(4));
    }

    /**
     * dp[0] = 0
     * dp[1] = dp[0]+1 = 1
     * dp[2] = dp[1]+1 = 2
     * dp[3] = dp[2]+1 = 3
     * dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
     * = Min{ dp[3]+1, dp[0]+1 }
     * = 1
     * dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
     * = Min{ dp[4]+1, dp[1]+1 }
     * = 2
     * dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}