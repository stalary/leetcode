/**
 * BinaryTreeMaximumPathSum124
 * 求二叉树中最大的路径和
 * @author lirongqian
 * @since 2018/05/13
 */
public class BinaryTreeMaximumPathSum124 {

    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 遍历左子树，找到非负值
        int left = Math.max(0, maxPathDown(node.left));
        // 遍历右子树，找到非负值
        int right = Math.max(0, maxPathDown(node.right));
        // 求出最大值
        maxValue = Math.max(maxValue, left + right + node.val);
        // 返回一条最大的路径
        return Math.max(left, right) + node.val;
    }
}