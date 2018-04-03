/**
 * ProductOfArrayExceptSelf238
 * 将数组转化为，每个元素都为除了他自己相乘的数组
 * @author lirongqian
 * @since 2018/04/03
 */
public class ProductOfArrayExceptSelf238 {

    /**
     * 首先先从前往后相乘，然后再从前往后依次相乘
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        // 1，2，3，4
        for (int i = 1; i < n; i++) {
            // 1，1，2，6
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            // 24，12，8，6
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}