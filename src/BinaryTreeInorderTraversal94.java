/**
 * @(#)BinaryTreeInorderTraversal94.java, 2017-12-27.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * BinaryTreeInorderTraversal94
 *
 * 二叉树的中序遍历
 * @author lirongqian
 * @since 27/12/2017
 */
public class BinaryTreeInorderTraversal94 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new BinaryTreeInorderTraversal94().inorderTraversal(root));
    }

    /**
     * 使用迭代的方法实现
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 找到最左边的子结点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

}