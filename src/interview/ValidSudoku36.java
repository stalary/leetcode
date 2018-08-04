/**
 * @(#)ValidSudoku36.java, 2018-08-04.
 * <p>
 * Copyright 2018 Stalary.
 */
package interview;

import java.util.HashSet;
import java.util.Set;

/**
 * ValidSudoku36
 * 判断是否是正确的数独
 *
 * @author lirongqian
 * @since 2018/08/04
 */
public class ValidSudoku36 {

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(new ValidSudoku36().isValidSudoku(board));
    }

    /**
     * set.add返回false代表已经存在该元素，则不满足条件
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> columns = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                // 判断行
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                // 判断列
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }
                // 转化成3*3矩阵
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.'
                        && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}