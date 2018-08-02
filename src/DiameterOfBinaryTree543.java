/**
 * DiameterOfBinaryTree543
 *
 * 求二叉树的最长路径
 *
 * 思路：
 * 递归的遍历二叉树的左儿子和右儿子，并对路径求和，每次求最大的路径
 * @author lirongqian
 * @since 2018/03/27
 */
public class DiameterOfBinaryTree543 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(new DiameterOfBinaryTree543().diameterOfBinaryTree(root));
    }

    /**
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     *
     * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
     */
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 递归查找左右结点的最大深度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 求出最大值
        max = Math.max(max, left + right);
        // 返回左右较大的值，并加一层深度
        return Math.max(left, right) + 1;
    }
}