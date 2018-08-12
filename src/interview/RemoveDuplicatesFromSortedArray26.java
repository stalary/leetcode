/**
 * @(#)RemoveDuplicatesFromSortedArray26.java, 2018-08-05.
 * <p>
 * Copyright 2018 Stalary.
 */
package interview;

import java.util.Arrays;

/**
 * RemoveDuplicatesFromSortedArray26
 * 移除重复的元素，但是不能增加新的数组，返回新数组的长度
 * @author lirongqian
 * @since 2018/08/05
 */
public class RemoveDuplicatesFromSortedArray26 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3, 3, 4, 5, 5
        };
        System.out.println(new RemoveDuplicatesFromSortedArray26().removeDuplicates(nums));
    }


    public int removeDuplicates(int[] nums) {
        int pos = 0;
        // 求出不相等元素的长度
        for (int num : nums) {
            if (nums[pos] != num) {
                nums[++pos] = num;
            }
        }
        System.out.println(Arrays.toString(nums));
        return pos + 1;
    }

}