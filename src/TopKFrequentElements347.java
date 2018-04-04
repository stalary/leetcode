import java.util.*;

/**
 * TopKFrequentElements347
 * 输出出现频繁的k种数字的数组
 * [1,1,1,2,2,3] and k = 2, return [1,2]
 *
 * @author lirongqian
 * @since 2018/04/04
 */
public class TopKFrequentElements347 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                4, 1, -1, 2, -1, 2, 3
        };
        System.out.println(new TopKFrequentElements347().topKFrequent(nums, 2));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 通过值进行排序，即按频繁度排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        List<Integer> result = new ArrayList<>();
        int count = 0;
        System.out.println(list);
        // 存入key
        for (Map.Entry<Integer, Integer> mapping : list) {
            if (count == k) {
                break;
            }
            result.add(mapping.getKey());
            count++;
        }
        return result;
    }
}