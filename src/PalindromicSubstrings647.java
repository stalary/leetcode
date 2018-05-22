
/**
 * PalindromicSubstrings647
 * 求最大的回文子串数量
 *
 * @author lirongqian
 * @since 2018/05/22
 */
public class PalindromicSubstrings647 {

    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            help(s, i, i);
            help(s, i, i + 1);
        }
        return count;
    }

    public void help(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
    }
}