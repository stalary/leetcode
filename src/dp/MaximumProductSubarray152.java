package dp;

/**
 * dp.MaximumProductSubarray152
 * 求相邻子数组乘积的最大值
 *
 * @author lirongqian
 * @since 2018/05/16
 */
public class MaximumProductSubarray152 {

    /**
     * 通过正反两次来求最优解，从而消除只有一个负数时，无法求得最优解得情况
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int sum = 1;
        // 通过正序和倒序两次计算求出最大值，当遇到0时，即代表归零，将sum变为1
        for (int i = 0; i < n; i++) {
            max = Math.max(max, sum *= nums[i]);
            if (nums[i] == 0) {
                sum = 1;
            }
        }
        sum = 1;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, sum *= nums[i]);
            if (nums[i] == 0) {
                sum = 1;
            }
        }
        return max;
    }
}