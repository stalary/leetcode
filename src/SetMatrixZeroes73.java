/**
 * @(#)SetMatrixZeroes73.java, 2019-03-28.
 *
 * Copyright 2019 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Arrays;

/**
 * SetMatrixZeroes73
 * 将所在行和列都设置为0
 * @author lirongqian
 * @since 2019/03/28
 */
public class SetMatrixZeroes73 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new SetMatrixZeroes73().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        boolean left = false;
        boolean top = false;
        int row = matrix.length;
        int col = matrix[0].length;
        // 判断第一列是否有0
        for (int y = 0; y < row; y++) {
            if (matrix[y][0] == 0) {
                left = true;
                break;
            }
        }
        // 判断第一行是否有0
        for (int x = 0; x < col; x++) {
            if (matrix[0][x] == 0) {
                top = true;
                break;
            }
        }

        for (int y = 1; y < row; y++) {
            for (int x = 1; x < matrix[y].length; x++) {
                if (matrix[y][x] == 0) {
                    matrix[y][0] = matrix[0][x] = 0;
                }
            }
        }

        for (int y = 1; y < row; y++) {
            if (matrix[y][0] == 0) {
                for (int x = 1; x < matrix[y].length; x++) {
                    matrix[y][x] = 0;
                }
            }
        }

        for (int x = 1; x < col; x++) {
            if (matrix[0][x] == 0) {
                for (int y = 1; y < matrix.length; y++) {
                    matrix[y][x] = 0;
                }
            }
        }

        if (top) {
            for (int x = 0; x < col; x++) {
                matrix[0][x] = 0;
            }
        }

        if (left) {
            for (int y = 0; y < row; y++) {
                matrix[y][0] = 0;
            }
        }
    }
}