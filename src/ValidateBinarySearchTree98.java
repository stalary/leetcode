import java.util.Stack;

/**
 * ValidateBinarySearchTree98
 * 判断是不是二叉搜索树
 *
 * @author lirongqian
 * @since 2018/05/17
 */
public class ValidateBinarySearchTree98 {

    /**
     * 中序遍历的变形
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            // 找最左节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 根节点
            root = stack.pop();
            // 判断是否符合二叉搜索树，当
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            // 记录前一个节点
            pre = root;
            // 遍历右节点
            root = root.right;
        }
        return true;
    }
}