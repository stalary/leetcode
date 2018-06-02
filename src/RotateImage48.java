/**
 * RotateImage48
 * 旋转二维数组
 * @author lirongqian
 * @since 2018/04/09
 */
public class RotateImage48 {

    public static void main(String[] args) {
        new RotateImage48().rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
    }

    /**
     1  2  3
     4  5  6
     7  8  9
     |
     1  4  7
     2  5  8
     3  6  9
     |
     7  4  1
     8  5  2
     9  6  3
     首先将横纵坐标互换，然后发现此时只是列还不对，所以再将前后的列进行交换。
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // 横纵坐标交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 交换列
        for (int i = 0; i < matrix.length; i++) {
            // 设置交换边界为中点
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

}