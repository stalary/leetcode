import java.util.*;

/**
 * WordBreak
 * 判断字符串能否由字典数组中的字符串组成
 *
 * @author lirongqian
 * @since 2018/05/02
 */
public class WordBreak {

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("acccbccb", Arrays.asList("cc", "bc", "ac", "ca")));
    }

    /**
     * 使用一个set来存储无法匹配的元素，每次将可以匹配的元素删除
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, new HashSet<>());
    }

    private boolean wordBreak(String s, List<String> wordDict, Set<String> cache) {
        if (cache.contains(s)) {
            return false;
        }
        for (String word : wordDict) {
            if (word.equals(s)) {
                return true;
            }
            if (s.startsWith(word)) {
                if (wordBreak(s.substring(word.length()), wordDict, cache)) {
                    return true;
                }
            }
        }
        // 存储当前不满足的字符串
        cache.add(s);
        return false;
    }
}