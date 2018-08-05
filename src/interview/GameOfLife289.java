/**
 * @(#)GameOfLife289.java, 2018-08-04.
 * <p>
 * Copyright 2018 Stalary.
 */
package interview;

/**
 * GameOfLife289
 * 生存游戏
 * 1为活，0为死亡
 * 周围八个元素
 *
 * @author lirongqian
 * @since 2018/08/04
 */
public class GameOfLife289 {

    /**
     * 1.活细胞周围的活细胞少于两个就会死亡
     * 2.活细胞周围有两个或者三个活细胞就会存活
     * 3.活细胞周围有多余三个活细胞就会死亡
     * 4.死细胞周围有刚好三个活细胞就会复活
     * [2nd bit, 1st bit] = [next state, current state]
     *
     * - 00  dead (next) <- dead (current)
     * - 01  dead (next) <- live (current)
     * - 10  live (next) <- dead (current)
     * - 11  live (next) <- live (current)
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);

                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Get the 2nd state.
            }
        }
    }

    /**
     * 计算邻居节点的存活数
     *
     * @param board
     * @param m
     * @param n
     * @param i
     * @param j
     * @return
     */
    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        // 防止越界
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                // 计算存活节点个数
                lives += board[x][y] & 1;
            }
        }
        // 去掉当前节点
        lives -= board[i][j] & 1;
        return lives;
    }
}