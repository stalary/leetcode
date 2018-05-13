package dp;

/**
 * dp.LargestRectangleInHistogram84
 * 最大矩形面积
 * @author lirongqian
 * @since 2018/05/13
 */
public class LargestRectangleInHistogram84 {

    /**
     * 首先求出当前高度的左右边界，然后遍历进行查找最大值
     * @param height
     * @return
     */
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length];
        int[] lessFromRight = new int[height.length];
        // 设置左右两侧的起始值
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;
            // 从当前位置查找最小的最左边界
            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;
            // 从当前位置查找最大的最右边界
            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        // dp的方式求最大面积
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

}