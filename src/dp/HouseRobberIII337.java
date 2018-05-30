package dp;

/**
 * dp.HouseRobberIII337
 * <p>
 * 对二叉树中的结点求和，求最大值，不能计算相连的结点
 *
 * @author lirongqian
 * @since 2018/04/01
 */
public class HouseRobberIII337 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(3);
        right.right = new TreeNode(1);
        root.left = left;
        root.right = right;
        System.out.println(new HouseRobberIII337().rob(root));
    }

    public int rob(TreeNode root) {
        int[] res = dfsHelper(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 每次查找子节点，并且求出当前节点和子节点节点的最大值
     * @param root
     * @return
     */
    public int[] dfsHelper(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) {
            return dp;
        }
        int[] dpL = dfsHelper(root.left);
        int[] dpR = dfsHelper(root.right);
        // 不偷取当前节点的最大值
        dp[0] = Math.max(dpL[0], dpL[1]) + Math.max(dpR[0], dpR[1]);
        // 偷取当前节点的最大值
        dp[1] = dpL[0] + dpR[0] + root.val;
        return dp;
    }
}