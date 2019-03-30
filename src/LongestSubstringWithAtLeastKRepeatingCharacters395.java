/**
 * @(#)LongestSubstringWithAtLeastKRepeatingCharacters395.java, 2019-03-30.
 *
 * Copyright 2019 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * LongestSubstringWithAtLeastKRepeatingCharacters395
 * 求出包含至少重复k次字符的最长子序列长度
 *
 * @author lirongqian
 * @since 2019/03/30
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters395 {

    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str, 0, s.length(), k);
    }

    private int helper(char[] str, int start, int end, int k) {
        if (end - start < k) {
            // 子串长度小于k时直接返回0
            return 0;
        }
        // 统计字符出现次数
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            int idx = str[i] - 'a';
            count[idx]++;
        }
        for (int i = 0; i < 26; i++) {
            // 当存在未重复次数大于等于k的字符时需要进一步缩小范围
            if (count[i] < k && count[i] > 0) {
                for (int j = start; j < end; j++) {
                    // 以不满足条件的元素为分界点
                    if (str[j] == i + 'a') {
                        int left = helper(str, start, j, k);
                        int right = helper(str, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }
}