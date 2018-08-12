package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * binarytree.BinaryTreePreorderTraversal144
 * <p>
 * 前序打印二叉树
 *
 * @author lirongqian
 * @since 2018/03/26
 */

public class BinaryTreePreorderTraversal144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                list.add(node.val);
                // 栈的弹出顺序与遍历顺序是相反的
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return list;
    }
}