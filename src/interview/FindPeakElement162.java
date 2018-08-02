/**
 * @(#)FindPeakElement162.java, 2018-08-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package interview;

/**
 * FindPeakElement162
 * 查找比邻居节点都大的元素
 * 找不到返回0
 * @author lirongqian
 * @since 2018/08/02
 */
public class FindPeakElement162 {

    public static void main(String[] args) {
        int[] num = new int[] {
                1,2,1,3,5,6,4
        };
        System.out.println(new FindPeakElement162().findPeakElement(num));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i] > nums[i + 1]) && (nums[i] > nums[i - 1])) {
                return i;
            }
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return 0;
    }
}