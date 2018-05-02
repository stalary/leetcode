/**
 * SearchInRotatedSortedArray33
 * 查找旋转数组中的一个数字
 *
 * @author lirongqian
 * @since 2018/05/01
 */
public class SearchInRotatedSortedArray33 {

    /**
     * 0 1 2 3 4 5 6 -》3 4 5 6 0 1 2
     * target 4 -》1
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            // 找到目标值时直接返回
            if (nums[m] == target) {
                return m;
            }
            // 当左边的小于等于中间值，判断如果目标值小于左边值或者大于中点值，则左边值为中点加1
            if (nums[l] <= nums[m]) {
                if (target < nums[l] || target > nums[m]) {
                    l = m + 1;
                } else {
                    // 否则右边值为中点减1(处于左边到中间的值)
                    h = m - 1;
                }
            } else {
                // 当左边值大于中间值时，目标值大于右边值或者小于中间值，右边值为中点减1
                if (target > nums[h] || target < nums[m]) {
                    h = m - 1;
                } else {
                    // 否则左边值为中点加1
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}