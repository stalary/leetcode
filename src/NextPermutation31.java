/**
 * NextPermutation31
 * 获取下一次的排列，当不能获取更大的值时，则返回从小到大排序
 *
 * @author lirongqian
 * @since 2018/05/10
 */
public class NextPermutation31 {

    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            // 大于等于最后一个元素时，左移，将该元素放到最后
            if (nums[i] >= nums[nums.length - 1]) {
                int temp = nums[i];
                for (int k = i; k < nums.length - 1; k++) {
                    nums[k] = nums[k + 1];
                }
                nums[nums.length - 1] = temp;
            } else {
                // 否则找到第一个大于之前元素的进行交换
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        return;
                    }
                }
            }
        }
    }

    /**
     * 交换
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}