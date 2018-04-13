package dp;

import java.util.Arrays;

/**
 * dp.CountingBits338
 *
 * 给定一个数字n，求出n范围内每个数字的二进制中1的个数
 * @author lirongqian
 * @since 2018/03/27
 */
public class CountingBits338 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits338().countBits(3)));
    }

    /**
     * 首先找规律发现从0开始二进制1中的数为0，1，1，2，1-》可以发现规律i/2个元素+i%2为后一个元素
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int[] arr = new int[num + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= num; i++) {
            arr[i] = arr[i / 2] + i % 2;
        }
        return arr;
    }
}