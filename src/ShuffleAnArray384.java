/**
 * @(#)ShuffleAnArray384.java, 2018-06-03.
 * <p>
 * Copyright 2018 Stalary.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ShuffleAnArray384
 * 返回数组的全排序中的一个，并且可以重置
 *
 * @author lirongqian
 * @since 2018/06/03
 */
public class ShuffleAnArray384 {

    private int[] nums;
    private Random random;

    public ShuffleAnArray384(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if (nums == null) {
            return null;
        }
        int[] a = nums.clone();
        for (int j = 1; j < a.length; j++) {
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}