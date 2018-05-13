/**
 * WordSearch79
 * 在二维数组中搜索数组
 *
 * @author lirongqian
 * @since 2018/05/13
 */
public class WordSearch79 {

    boolean res = false;

    /**
     * 使用广搜的方法进行查找
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        char[] c = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 首先先找到起点
                if (board[i][j] != c[0]) {
                    continue;
                }
                search(c, 0, board, i, j, flag);
                if (res) {
                    return true;
                }

            }
        }
        return false;
    }

    private void search(char[] c, int i, char[][] board, int curRow, int curCol, boolean[][] flag) {
        // 当找到元素最后或者有能找到的路径时，直接返回true
        if (res || i == c.length) {
            res = true;
            return;
        }
        // 边界检测
        if (curRow < 0 || curRow >= board.length || curCol < 0 || curCol >= board[0].length || flag[curRow][curCol] || board[curRow][curCol] != c[i]) {
            return;
        }
        // 设置当前点已遍历
        flag[curRow][curCol] = true;
        // 向右查找
        search(c, i + 1, board, curRow, curCol + 1, flag);
        // 向下查找
        search(c, i + 1, board, curRow + 1, curCol, flag);
        // 向左查找
        search(c, i + 1, board, curRow, curCol - 1, flag);
        // 向上查找
        search(c, i + 1, board, curRow - 1, curCol, flag);

        // 回溯
        flag[curRow][curCol] = false;
    }
}