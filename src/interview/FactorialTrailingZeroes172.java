/**
 * @(#)FactorialTrailingZeroes172.java, 2018-08-12.
 * <p>
 * Copyright 2018 Stalary.
 */
package interview;

/**
 * FactorialTrailingZeroes172
 * 返回阶乘以后0的数量
 * @author lirongqian
 * @since 2018/08/12
 */
public class FactorialTrailingZeroes172 {

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes172().trailingZeroes(5));
    }

    /**
     * 直接找到5的数量或者10的个数(*2)
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}