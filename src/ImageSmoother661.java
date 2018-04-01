/**
 * ImageSmoother661
 * <p>
 * 给定一个矩阵，将每一个元素周围八个元素以及自己下取整再赋值给自己，若在边界则不取
 * Input:
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * Output:
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 *
 * @author lirongqian
 * @since 2018/04/01
 */
public class ImageSmoother661 {

    public static void main(String[] args) {

    }

    /**
     * 可以使用一个-1，0，1的数组来表示动作
     *
     * @param M
     * @return
     */
    public int[][] imageSmoother(int[][] M) {
        int nx = M.length;
        int ny = M[0].length;
        // 申请新数组，存放变化后的元素
        int[][] res = new int[nx][ny];
        for (int i = 0; i < nx; i++) {
            for (int j = 0; j < ny; j++) {
                res[i][j] = smooth(M, i, j);
            }
        }
        return res;
    }

    private int smooth(int[][] M, int x, int y) {
        int nx = M.length;
        int ny = M[0].length;
        int sum = 0;
        int count = 0;

        /**
         * 向上下左右移动
         */
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // 出界时直接跳出
                if (x + i < 0 || x + i >= nx || y + j < 0 || y + j >= ny) {
                    continue;
                }
                // 统计总数
                count++;
                // 求和
                sum += M[x + i][y + j];
            }
        }

        return sum / count;
    }
}