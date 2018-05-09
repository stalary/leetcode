/**
 * JumpGame55
 * 判断是否可以跳到最后
 * @author lirongqian
 * @since 2018/05/09
 */
public class JumpGame55 {

    public static void main(String[] args) {
        System.out.println(new JumpGame55().canJump(new int[] {
                2,3,1,1,4
        }));
    }

    /**
     * 每次将当前数加上下标与最大长度进行比较
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int i = 0;
        int maxLen = nums[i];
        while (i < nums.length - 1) {
            // 求所能到达最大长度
            maxLen = Math.max(maxLen, nums[i] + i);
            if (i == maxLen) {
                return false;
            }
            i++;
        }
        return true;
    }
}