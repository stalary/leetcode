/**
 * IslandPerimeter463
 * <p>
 * 1的四周都是边
 * 求二维数组一共有多少条边，
 *
 * @author lirongqian
 * @since 2018/04/02
 */
public class IslandPerimeter463 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // 额外申请一圈，防止数组越界
        boolean[][] temp = new boolean[n + 2][m + 2];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // 首先将所有为1的点赋值
                if (grid[i - 1][j - 1] == 1) {
                    temp[i][j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (temp[i][j]) {
                    // 统计四周的数量，当不是1时，即递增
                    if (!temp[i - 1][j]) {
                        count++;
                    }
                    if (!temp[i][j - 1]) {
                        count++;
                    }
                    if (!temp[i + 1][j]) {
                        count++;
                    }
                    if (!temp[i][j + 1]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 先计算为无相邻，再相减
     *
     * @param grid
     * @return
     */
    public int islandPerimeter1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    // 减2是由于，相邻时，两边重合
                    if (i > 0 && grid[i - 1][j] == 1) {
                        result -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }
}