
/**
 * BalancedBinaryTree110
 *
 * 判断一颗二叉树是不是平衡二叉树
 * @author lirongqian
 * @since 2018/03/23
 */
public class BalancedBinaryTree110 {

    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        getDepth(root);
        return flag;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 获取左边结点的深度
        int left = getDepth(root.left);
        // 获取右边结点的深度
        int right = getDepth(root.right);
        // 当差值大于1时返回错误
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        // 每次将最大的深度加1
        return right > left ? right + 1 : left + 1;
    }
}