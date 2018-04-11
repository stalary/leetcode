/**
 * MinimumPathSum64
 * 求二维数组中的最小路径和(左上到右下)
 * 只能向下或者向右移动
 * @author lirongqian
 * @since 2018/04/10
 */
public class MinimumPathSum64 {

    /**
     * 简单的动态规划可知，最后一个点即为所求的路径数
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    // 保存当前的路径值
                    grid[i][j] += grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (i != 0 && j != 0){
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}