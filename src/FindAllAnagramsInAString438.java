import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FindAllAnagramsInAString438
 * 寻找字符串
 * @author lirongqian
 * @since 2018/04/28
 */
public class FindAllAnagramsInAString438 {

    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsInAString438().findAnagrams("abab", "ab"));
    }

    /**
     * Input:
     * s: "cbaebabacd" p: "abc"
     *
     * Output:
     * [0, 6]
     *
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return list;
        }
        // 申请hash桶
        int[] hash = new int[256];
        char[] chars = p.toCharArray();
        // 将p中出现的字符存入桶中
        for (char c : chars) {
            hash[c]++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            // 移动right，当存在于p中时，count--，先判断，再递减
            if (hash[s.charAt(right++)]-- >= 1) {
                count--;
            }
            // 当count=0时代表此时出现匹配的串
            if (count == 0) {
                list.add(left);
            }
            // 构造新的匹配框
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
                count++;
            }
        }
        return list;
    }
}