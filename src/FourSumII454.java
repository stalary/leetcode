/**
 * @(#)FourSumII454.java, 2018-06-02.
 * <p>
 * Copyright 2018 Stalary.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * FourSumII454
 * 给定四个tuple，计算一共有多少种方式可以求和为0
 *
 * @author lirongqian
 * @since 2018/06/02
 */
public class FourSumII454 {

    /**
     * 使用map存储一半的sum，然后判断另一半的相反数存在于map中的数量
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                res += map.getOrDefault(-1 * (A[i] + B[j]), 0);
            }
        }

        return res;
    }
}