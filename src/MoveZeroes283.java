import java.util.Arrays;

/**
 * MoveZeroes283
 * 移动零
 * @author lirongqian
 * @since 2018/05/26
 */
public class MoveZeroes283 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                0, 1, 0, 3, 12
        };
        new MoveZeroes283().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将非零元素存入，统计非零数量，最后写入差值数量个零
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        int len = nums.length;
        while (index < len) {
            nums[index++] = 0;
        }
    }
}