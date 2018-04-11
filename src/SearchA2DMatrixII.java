/**
 * SearchA2DMatrixII
 * 二维数组中进行查找
 * @author lirongqian
 * @since 2018/04/11
 */
public class SearchA2DMatrixII {

    /**
     * 从右上角开始查找，往下是增加，左是减少
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}