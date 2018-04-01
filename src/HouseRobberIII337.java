/**
 * HouseRobberIII337
 *
 * 对二叉树中的结点求和，求最大值，不能计算相连的结点
 * @author lirongqian
 * @since 2018/04/01
 */
public class HouseRobberIII337 {

    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = 0;
        if (root.right != null) {
            val += rob(root.right.right) + rob(root.right.left);
        }
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        // 求出左右儿子或者左右儿子下一层的最大值
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}