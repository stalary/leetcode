package dp;

/**
 * dp.ContainerWithMostWater11
 * 求最大容器
 *
 * @author lirongqian
 * @since 2018/04/15
 */
public class ContainerWithMostWater11 {

    /**
     * 1 8 6 2 5 4 8 3 7
     * 两个值之间的最小值乘于之间的距离所得的最大值即为最大容器
     * 分别从左右两边进行查找
     * 找到左右两边的最小值然w后乘于之间的距离，求之间的最大值
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}