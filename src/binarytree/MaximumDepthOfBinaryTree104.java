package binarytree;

/**
 * binarytree.MaximumDepthOfBinaryTree104
 * 求二叉树最大深度
 * @author lirongqian
 * @since 2018/05/22
 */
public class MaximumDepthOfBinaryTree104 {

    /**
     * 最大深度，递归查找左右子树即可，每次+1
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}