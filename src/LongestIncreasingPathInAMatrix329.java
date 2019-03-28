/**
 * @(#)LongestIncreasingPathInAMatrix329.java, 2019-03-28.
 *
 * Copyright 2019 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * LongestIncreasingPathInAMatrix329
 * 查找二维数组中最长的递增队列
 * @author lirongqian
 * @since 2019/03/28
 */
public class LongestIncreasingPathInAMatrix329 {

    /**
     * 四个方向的移动数组
     **/
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 对每一个点进行搜索
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    /**
     * 广搜
     **/
    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        // 防止重复查找
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int max = 1;
        // 向四个方向搜索
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }
}