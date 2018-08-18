import java.util.*;

/**
 * TopKFrequentElements347
 * 输出出现频繁的k种数字的数组
 * [1,1,1,2,2,3] and k = 2, return [1,2]
 * 返回k个频繁出现的数
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

    public List<Integer> topKFrequent1(int[] nums, int k) {
        // 存储值和次数的映射
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
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Pair> pairs = new PriorityQueue<>(Comparator.comparing(a -> a.count));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pairs.add(new Pair(entry.getKey(), entry.getValue()));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pairs.poll().num);
        }
        return result;
    }

    public static class Pair{

        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

}