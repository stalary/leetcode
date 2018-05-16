package dp;

import java.util.Arrays;

/**
 * CoinChange322
 * 给定一组硬币，和一个目标值，求最少需要多少枚硬币
 *
 * @author lirongqian
 * @since 2018/05/16
 */
public class CoinChange322 {

    public static void main(String[] args) {
        System.out.println(new CoinChange322().coinChange(new int[]{1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 默认值设置为最大值减1
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = 1; j < amount + 1; j++) {
                // 当仍然可以被交换时
                if (j - coin >= 0) {
                    // 求最小的数量，当前数量与之前数量+1相比较
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        // 即代表没有可以交换的方式
        if (dp[amount] == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return dp[amount];
    }
}