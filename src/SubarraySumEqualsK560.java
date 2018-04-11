import java.util.HashMap;
import java.util.Map;

/**
 * SubarraySumEqualsK560
 * 求数组中和为k的子序列
 *
 * @author lirongqian
 * @since 2018/04/11
 */
public class SubarraySumEqualsK560 {

    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer,Integer> preSum = new HashMap<>();
        // 设置能找到的默认有一个
        preSum.put(0, 1);

        for (int num : nums) {
            // 求出当前的和
            sum += num;
            // 如果之前存在sum - k，则这两个位置之间的数字相加为k，sum-k-》sum之间有k个元素，所以求出sum-k的数量即可
            result += preSum.getOrDefault(sum - k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}