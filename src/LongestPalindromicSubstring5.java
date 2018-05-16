/**
 * LongestPalindromicSubstring5
 * 最长回文字符串
 *
 * @author lirongqian
 * @since 2018/05/16
 */
public class LongestPalindromicSubstring5 {

    /**
     * 回文起始点
     */
    private int lo;

    /**
     * 回文长度
     */
    private int maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        // 长度小于等于2时，返回当前字符串
        if (len <= 1) {
            return s;
        }
        for (int i = 0; i < len - 1; i++) {
            // 分别判断奇数和偶数的时候
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            // 向两遍扩展
            j--;
            k++;
        }
        // 当回文长度增加时，统计最大长度，记录起始点
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}