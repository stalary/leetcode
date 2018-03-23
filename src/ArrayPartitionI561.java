
import java.util.Arrays;

/**
 * ArrayPartitionI561
 *
 * 求两个数之间较小数的所有数字和
 * @author lirongqian
 * @since 2018/03/23
 */
public class ArrayPartitionI561 {

    public static void main(String[] args) {
        int[] nums = new int[] {
                1,4,3,2
        };
        System.out.println(arrayPairSum(nums));
    }

    /**
     * 1，4，3，2-》min(1，2) + min(3，4) = 4
     * 首先将数组进行排序，然后再两两一组，每次将第一个数字加入
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}