package dp;

/**
 * dp.HouseRobber198
 * <p>
 * 给定一个数组，每一个元素代表钱数，不可以偷取相邻的元素，求可以获取到的最大的金额
 *
 * @author lirongqian
 * @since 2018/04/01
 */
public class HouseRobber198 {

    public static void main(String[] args) {
        System.out.println(new HouseRobber198().rob(new int[]{}));
    }

    /**
     * 按奇偶分别相加，最后求出最大值
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) != 1) {
                a += nums[i];
                a = Math.max(a, b);
            } else {
                b += nums[i];
                b = Math.max(a, b);
            }
        }
        return Math.max(a, b);
    }

    /**
     * 一般来说，给定一个规则，让我们求任意状态下的解，都是用动态规划。这里的规则是劫匪不能同时抢劫相邻的屋子，即我们在累加时，只有两种选择：

     如果选择了抢劫上一个屋子，那么就不能抢劫当前的屋子，所以最大收益就是抢劫上一个屋子的收益

     如果选择抢劫当前屋子，就不能抢劫上一个屋子，所以最大收益是到上一个屋子的上一个屋子为止的最大收益，加上当前屋子里有的钱

     动态规划
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        if(nums.length <= 1){
            return nums.length == 0 ? 0 : nums[0];
        }
        // a是上次的最大收益
        int a = nums[0];
        // b是当前的最大受益
        int b = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = b;
            // 当前的最大收益是两种选择里较大的那个
            b = Math.max(a + nums[i], b);
            a = tmp;
        }
        return b;
    }
}