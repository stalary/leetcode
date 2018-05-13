import java.util.HashMap;
import java.util.Map;

/**
 * MinimumWindowSubstring76
 * 查找包含子串最小的窗口
 *
 * @author lirongqian
 * @since 2018/05/13
 */
public class MinimumWindowSubstring76 {

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring76().minWindow("cabwefgewcwaefgcf", "cae"));
    }

    /**
     * 使用Map统计字符出现的次数
     * 移动right指针找到符合要求的字符串
     * 移动left指针来缩小范围
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        char[] arr = s.toCharArray();
        for (int right = 0; right < arr.length; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) - 1);
            // 命中则count++
            if (map.get(arr[right]) >= 0) {
                count++;
            }
            // 当都命中时，开始求最小的长度
            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLeft = left;
                    minLen = right - left + 1;
                }
                map.put(arr[left], map.getOrDefault(arr[left], 0) + 1);
                if (map.get(arr[left]) > 0) {
                    count--;
                }
                left++;
            }
        }
        if (minLen > s.length()) {
            return "";
        }
        return s.substring(minLeft, minLeft + minLen);
    }
}