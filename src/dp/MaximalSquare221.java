package dp;

/**
 * dp.MaximalSquare221
 * 求1的最大正方形面积
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 * @author lirongqian
 * @since 2018/05/04
 */
public class MaximalSquare221 {

    public static void main(String[] args) {
        char[][] a = new char[][] {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(new MaximalSquare221().maximalSquare(a));
    }

    /**
     * 求出正方形最大的边长
     * @param a
     * @return
     */
    public int maximalSquare(char[][] a) {
        if (a.length == 0) {
            return 0;
        }
        int m = a.length, n = a[0].length, result = 0;
        // 扩充一层边界，防止越界
        int[][] b = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1][j - 1] == '1') {
                    // 获取三个周围点的最小值
                    b[i][j] = Math.min(Math.min(b[i][j - 1], b[i - 1][j - 1]), b[i - 1][j]) + 1;
                    result = Math.max(b[i][j], result);
                }
            }
        }
        return result * result;
    }
}