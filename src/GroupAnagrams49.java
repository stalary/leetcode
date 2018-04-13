import java.util.*;

/**
 * GroupAnagrams49
 * 将由相同元素组成的字符串进行分组
 *
 * @author lirongqian
 * @since 2018/04/13
 */
public class GroupAnagrams49 {

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams49().groupAnagrams(new String[] {
                "eat", "tea", "tan", "ate", "nat", "bat"
        }));
    }

    /**
     * 将每一个字符串排序，存入map进行比较，不存在的则创建新的map
     * 存在则向map中添加新的元素
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}