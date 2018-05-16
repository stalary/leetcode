import java.util.HashSet;
import java.util.Set;

/**
 * LongestSubstringWithoutRepeatingCharacters3
 * 最长非重复子串
 * @author lirongqian
 * @since 2018/05/16
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        // i代表第一次出现的点，通过size即可判断最大的元素
        while (j < s.length()) {
            if (!set.contains(chars[j])) {
                set.add(chars[j++]);
                max = Math.max(max, set.size());
            } else {
                set.remove(chars[i++]);
            }
        }
        return max;
    }
}