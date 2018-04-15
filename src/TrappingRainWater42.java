/**
 * TrappingRainWater42
 * 存水量
 *
 * @author lirongqian
 * @since 2018/04/15
 */
public class TrappingRainWater42 {

    /**
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * [0,1,0,2,1,0,1,3,2,1,2,1]
     *             ||
     *             \/
     *  0,0,1,1,2,4,5,5,5,6,6,6
     *  当左边的最大值小于右边的最大值时，可以进行存储左边最大值减去当前值的水
     *  当左边的最大值大于右边的最大值时，可以进行存储右边的最大值减去当前值的水
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int a = 0;
        int b = height.length - 1;
        int max = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (a <= b) {
            leftMax = Math.max(leftMax, height[a]);
            rightMax = Math.max(rightMax, height[b]);
            if (leftMax < rightMax) {
                // leftMax is smaller than rightMax, so the (leftMax-A[a]) water can be stored
                max += (leftMax - height[a]);
                a++;
            } else {
                max += (rightMax - height[b]);
                b--;
            }
        }
        return max;
    }
}