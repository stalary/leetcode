package backtracked; /**
 * @(#)PalindromePartitioning131.java, 2019-03-27.
 *
 * Copyright 2019 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * backtracked.PalindromePartitioning131
 *
 * @author lirongqian
 * @since 2019/03/27
 */
public class PalindromePartitioning131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), s.toCharArray(), 0);
        return res;
    }

    void dfs(List<List<String>> res, ArrayList<String> list, char[] c, int pos) {
        // 当移动到末尾时代表一次分区完成(回溯结束的条件)
        if (pos == c.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = pos; i < c.length; i++) {
            // 判断是否为回文
            if (isPal(c, pos, i)){
                // 加入回文的分区
                list.add(new String(c, pos, i - pos + 1));
                // 继续向后添加
                dfs(res, list, c, i + 1);
                // 回溯
                list.remove(list.size() - 1);
            }
        }
    }

    boolean isPal(char[] c, int start, int end) {
        while (start < end) {
            if (c[start++] != c[end--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("ret: " + new PalindromePartitioning131().partition("aab"));
    }
}