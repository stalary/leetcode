/**
 * FindPivotIndex724
 *
 * 找出能分割数组的点的坐标，若不存在则返回-1， 1 7 3 6 5 6 为3，即6
 * 即使两边元素相等
 *
 * @author lirongqian
 * @since 2018/03/27
 */
public class FindPivotIndex724 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 7, 3, 6, 5, 6
        };
        FindPivotIndex724 f = new FindPivotIndex724();
        System.out.println(f.pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int out : nums) {
            sum += out;
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            // 存储前半部分的值
            temp += nums[i];
            if (temp == sum - temp + nums[i]) {
                return i;
            }
        }
        return -1;
    }
}