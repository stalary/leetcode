import java.util.HashMap;

/**
 * FindTheDifference389
 *
 * 将第一个字符串打乱顺序，并且加入一个元素，查找新加入的元素
 * @author lirongqian
 * @since 2018/03/27
 */
public class FindTheDifference389 {

    public static void main(String[] args) {
        System.out.println(findTheDifference("abicdiefgh", "abideiicfhg"));
    }

    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            if (!map.containsKey(temp)) {
                return t.charAt(i);
            } else {
                if (map.get(temp) == 0) {
                    return t.charAt(i);
                }
                map.put(temp, map.get(temp) - 1);
            }
        }
        return t.charAt(0);
    }

    /**
     * 使用位运算，来查找不一致的字符
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference1(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); ++i) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            c ^= t.charAt(i);
        }
        return c;
    }
}