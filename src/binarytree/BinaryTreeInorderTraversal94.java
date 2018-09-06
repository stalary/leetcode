package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * binarytree.BinaryTreeInorderTraversal94
 * <p>
 * 二叉树的中序遍历
 *
 * @author lirongqian
 * @since 2018/03/26
 */
public class BinaryTreeInorderTraversal94 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.left = new TreeNode(5);
//        new BinaryTreeInorderTraversal94().inorder(root);
        System.out.println(new BinaryTreeInorderTraversal94().inorderTraversal(root));
    }

    /**
     * 使用栈的方法实现
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            // 依次查找最左结点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 输出中间根
            root = stack.pop();
            list.add(root.val);
            // 遍历右节点
            root = root.right;
        }
        return list;
    }

}