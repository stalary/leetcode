import java.util.*;

/**
 * TwoSum1
 * 求出数组中能组成target的两个数
 *
 * @author lirongqian
 * @since 2018/04/14
 */
public class TwoSum1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum1().twoSum(new int[] {
                2, 7, 11, 15
        }, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        // map存储值和下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{
                        map.get(target - nums[i]), i
                };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}