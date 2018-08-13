package binarytree;

/**
 * binarytree.FindBottomLeftTreeValue513
 *
 * 找到二叉树最左边底部元素
 * @author lirongqian
 * @since 2018/03/27
 */
public class FindBottomLeftTreeValue513 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(3);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(5);
        System.out.println(new FindBottomLeftTreeValue513().findBottomLeftValue(node));
    }
    int ans = 0, h = 0;

    /**
     * 主要为查找最底部的元素
     *          4
     *       3     2
     *                5
     *  返回5
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return ans;
    }

    public void findBottomLeftValue(TreeNode root, int depth) {
        // 当继续深入时，添加元素
        if (h < depth) {
            ans = root.val;
            h = depth;
        }
        /**
         * 当仍然存在子结点时，继续递归遍历
         */
        if (root.left != null) {
            findBottomLeftValue(root.left, depth + 1);
        }
        if (root.right != null) {
            findBottomLeftValue(root.right, depth + 1);
        }
    }
}