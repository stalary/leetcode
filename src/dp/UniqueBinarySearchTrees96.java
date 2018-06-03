package dp; /**
 * @(#)UniqueBinarySearchTrees96.java, 2018-06-03.
 * <p>
 * Copyright 2018 Stalary.
 */

/**
 * dp.UniqueBinarySearchTrees96
 * 输入1-n，求能够构建出多少种二叉搜索树
 * @author lirongqian
 * @since 2018/06/03
 */
public class UniqueBinarySearchTrees96 {

    public int numTrees(int n) {
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        for (int level = 2; level <= n; level++) {
            for (int root = 1; root <= level; root++) {
                num[level] += num[root - 1] * num[level - root];
            }
        }
        return num[n];
    }
}