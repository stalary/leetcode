import java.util.Stack;

/**
 * MaximalRectangle85
 * 求最大矩形
 *
 * @author lirongqian
 * @since 2018/05/08
 */
public class MaximalRectangle85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // 列数
        int cLen = matrix[0].length;
        // 行数
        int rLen = matrix.length;
        // 列的数组
        int[] h = new int[cLen + 1];
        h[cLen] = 0;
        int max = 0;

        for (int row = 0; row < rLen; row++) {
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < cLen + 1; i++) {
                if (i < cLen) {
                    if (matrix[row][i] == '1') {
                        h[i] += 1;
                    } else {
                        h[i] = 0;
                    }
                }
                if (s.isEmpty() || h[s.peek()] <= h[i]) {
                    s.push(i);
                } else {
                    while (!s.isEmpty() && h[i] < h[s.peek()]) {
                        int top = s.pop();
                        int area = h[top] * (s.isEmpty() ? i : (i - s.peek() - 1));
                        if (area > max) {
                            max = area;
                        }
                    }
                    s.push(i);
                }
            }
        }
        return max;
    }
}