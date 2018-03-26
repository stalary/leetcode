/**
 * @(#)BinaryTreeLevelOrderTraversal102.java, 2018-01-02.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BinaryTreeLevelOrderTraversal102
 *
 * 二叉树的层序遍历，由根开始打印
 * @author lirongqian
 * @since 02/01/2018
 */
public class BinaryTreeLevelOrderTraversal102 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 首先存入根节点
        queue.add(root);
        while (queue.size() > 0) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 将当前结点加入list
                list.add(node.val);
                // 如果存在左右儿子，分别放入队列中(进入下一层)
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}