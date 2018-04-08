/**
 * UniquePaths62
 * 求出到达终点的路径数量
 *
 * @author lirongqian
 * @since 2018/04/07
 */
public class UniquePaths62 {

    /**
     * 动态规划的思想，最后到达的地方即为所要求的值
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] map = new int[m][n];
        // 为横轴赋值
        for (int i = 0; i < m; i++) {
            map[i][0] = 1;
        }
        // 为纵轴赋值
        for (int j = 0; j < n; j++) {
            map[0][j] = 1;
        }
        // 向下和向右移动
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }
}