package binarytree;

/**
 * binarytree.InvertBinaryTree226
 *
 * 交换二叉树的左右结点
 *
 * Invert a binary tree.

        4
      /   \
     2     7
    / \   / \
   1   3 6   9
 to

        4
      /   \
     7     2
    / \   / \
   9   6 3   1
 * @author lirongqian
 * @since 2018/04/01
 */
public class InvertBinaryTree226 {

    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 递归的交换左右的结点
        TreeNode node = root.left;
        root.left = invertTree(root.right);
        // node为提前保存的左节点
        root.right = invertTree(node);
        return root;
    }

}