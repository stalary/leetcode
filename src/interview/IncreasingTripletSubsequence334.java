/**
 * @(#)IncreasingTripletSubsequence334.java, 2018-08-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package interview;

/**
 * IncreasingTripletSubsequence334
 * 判断数组中是否包含三个递增的子数组，不要求连续
 * @author lirongqian
 * @since 2018/08/02
 */
public class IncreasingTripletSubsequence334 {

    public static void main(String[] args) {
        int[] num = new int[]{
                5, 4, 3, 2, 1
        };
        System.out.println(new IncreasingTripletSubsequence334().increasingTriplet(num));
    }

    /**
     * Input: [1,2,3,4,5]
     * Output: true
     *
     * Input: [5,4,3,2,1]
     * Output: false
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        // 按顺序查找并赋值，找到第一小和第二小的元素
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num < secondMin) {
                secondMin = num;
            } else if (num > secondMin) {
                return true;
            }
        }
        return false;
    }
}