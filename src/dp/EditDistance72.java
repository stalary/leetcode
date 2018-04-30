package dp;

/**
 * EditDistance72
 * 通过增加，删除，替换word1，使其和word2相同
 * @author lirongqian
 * @since 2018/04/30
 */
public class EditDistance72 {

    int[][] dp;

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];

        return minDistanceHelper(word1, word2, 0, 0);
    }

    /**
     * 通过dp
     * 对三种状态进行判断
     * 求出最小的result
     * @param word1
     * @param word2
     * @param index1
     * @param index2
     * @return
     */
    private int minDistanceHelper(String word1, String word2, int index1, int index2) {
        if (index1 == word1.length()) {
            return word2.length() - index2;
        }
        if (index2 == word2.length()) {
            return word1.length() - index1;
        }

        if (dp[index1][index2] > 0) {
            return dp[index1][index2];
        }

        int result;
        if (word1.charAt(index1) == word2.charAt(index2)) {
            // 相同时继续向后查找
            result = minDistanceHelper(word1, word2, index1+1, index2+1);
        } else {
            // 替换字符
            result = 1 + minDistanceHelper(word1, word2, index1+1, index2+1);

            // 删除一个字符
            result = Math.min(result, 1 + minDistanceHelper(word1, word2, index1+1, index2));

            // 添加一个字符
            result = Math.min(result, 1 + minDistanceHelper(word1, word2, index1, index2+1));
        }

        dp[index1][index2] = result;
        return result;
    }
}