import java.util.HashMap;
import java.util.Map;

/**
 * LongestConsecutiveSequence128
 * 求最大连续子序列的长度
 * @author lirongqian
 * @since 2018/04/14
 */
public class LongestConsecutiveSequence128 {

    public static void main(String[] args) {

    }

    /**
     * [100, 4, 200, 1, 3, 2],
     * [1, 2, 3, 4]，Return its length: 4
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            // 过滤掉本身
            if (map.containsKey(num)) {
                continue;
            }
            // 查找左边和右边的元素
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int sum = left + right + 1;
            max = Math.max(max, sum);

            // 更新左右两边的sum，同步大小
            if (left > 0) {
                map.put(num - left, sum);
            }
            if (right > 0) {
                map.put(num + right, sum);
            }
            // 存储当前位置的和
            map.put(num, sum);
        }
        return max;
    }
}