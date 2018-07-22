package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * dp.LongestValidParentheses32
 * 最长匹配括号
 *
 * @author lirongqian
 * @since 2018/05/20
 */
public class LongestValidParentheses32 {

    public int longestValidParentheses(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int max = 0;
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                count++;
                map.put(count, i);
            } else {
                // 当count小于min即代表完成匹配或者为起点
                count--;
                if (count < min) {
                    map.put(count, i);
                    min = count;
                } else {
                    // 当未完成匹配时，求一下最大值
                    max = Math.max(max, i - map.get(count));
                }
            }
        }
        return max;
    }

    /**
     * 使用dp的思想
     * @param s
     * @return
     */
    public static int longestValidParentheses1(String s) {
        int len = s.length();
        // dp数组
        int[] maxes = new int[len];
        // 左括号的数量
        int leftCnt = 0, max = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                maxes[i] = 0;
                leftCnt++;
            } else if (')' == c) {
                // 当左括号的数量小于1时代表无法匹配，直接向后移动
                if (leftCnt < 1) {
                    continue;
                }
                // 上一次匹配成功的括号数量加上2个括号
                int curLen = maxes[i - 1] + 2;
                if (i > curLen) {
                    curLen = curLen + maxes[i - curLen];
                }
                // 出现一个右括号时，匹配一个左括号
                leftCnt -= 1;
                // 替换当前最大值
                maxes[i] = curLen;
                max = Math.max(curLen, max);
            }
        }
        return max;
    }
}