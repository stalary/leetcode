import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * LRUCache146
 * 构建最近最少使用的缓存
 * @author lirongqian
 * @since 2018/05/20
 */
public class LRUCache146 {

    public static void main(String[] args) {
        LRUCache146 cache = new LRUCache146(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }

    LinkedHashMap<Integer, Integer> map;

    int capacity;
    public LRUCache146(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int result = map.get(key);
        map.remove(key);
        map.put(key, result);
        return result;
    }

    public void put(int key, int value) {
        map.remove(key);
        if (map.size() == capacity) {
            Iterator<Integer> it = map.keySet().iterator();
            if (it.hasNext()) {
                int result = it.next();
                map.remove(result);
            }
        }
        map.put(key, value);
    }

}