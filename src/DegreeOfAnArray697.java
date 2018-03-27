
import java.util.HashMap;
import java.util.Map;

/**
 * DegreeOfAnArray697
 *
 * 找到重复次数最多的元素，求出起始到结束的最小距离
 * @author lirongqian
 * @since 2018/03/27
 */
public class DegreeOfAnArray697 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 2, 3, 1, 4, 2
        };
        System.out.println(findShortestSubArray(nums));
    }

    /**
     * 创建一个含有3个元素的数组，arr[0]代表出现次数，arr[1]代表第一次出现的位置，arr[2]代表最后一次出现的位置
     *
     * @param nums
     * @return
     */
    public static int findShortestSubArray(int[] nums) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                // 当不存在时，初始化数组
                int[] arr = new int[3];
                arr[0] = 1;
                arr[1] = i;
                arr[2] = i;
                map.put(nums[i], arr);
            }
            // 找出出现重复次数最多的元素
            max = Math.max(max, map.get(nums[i])[0]);
        }
        for (int n : map.keySet()) {
            if (max == map.get(n)[0]) {
                // 求出距离的最大值
                min = Math.min(min, map.get(n)[2] - map.get(n)[1]);
            }
        }
        return min + 1;
    }

}