/**
 * NumberOfIslands200
 * 求小岛的数量
 *
 * @author lirongqian
 * @since 2018/04/16
 */
public class NumberOfIslands200 {

    public static void main(String[] args) {
        System.out.println(new NumberOfIslands200().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
    }

    /**
     * 使用dfs，查找四个方向的点，当不存在1时，代表是一个孤立的小岛
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int sum = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    help(grid, i, j);
                    sum++;
                }
            }
        }
        return sum;
    }

    public void help(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        // 已经查找过的跳过
        grid[i][j] = '0';
        help(grid, i - 1, j);
        help(grid, i + 1, j);
        help(grid, i, j - 1);
        help(grid, i, j + 1);
    }
}