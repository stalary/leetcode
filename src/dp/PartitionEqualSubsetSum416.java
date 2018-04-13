package dp;

/**
 * dp.PartitionEqualSubsetSum416
 * 判断数组是否能够分成两个相等的部分
 * @author lirongqian
 * @since 2018/04/13
 */
public class PartitionEqualSubsetSum416 {

    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum416().canPartition(new int[] {
                1, 5, 11, 5
        }));
    }

    /**
     * 类似背包问题，首先求出总和，然后求是否存在sum/2的子项和
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        // 求和
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        // 当为奇数时，肯定不存在相同的两部分，直接返回false
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        // 初始化
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = sum; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] | dp[j - nums[i - 1]];
            }
        }
        return dp[sum];
    }
}