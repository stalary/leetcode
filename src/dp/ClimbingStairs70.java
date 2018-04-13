package dp;

/**
 * dp.ClimbingStairs70
 *
 * 一个人每次可以走一步或者两步，给定台阶数量，输出方法的数量
 * @author lirongqian
 * @since 2018/03/26
 */
public class ClimbingStairs70 {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs70().climbStairs(4));
    }

    /**
     * 可以通过找规律找出方程
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] a = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }
}