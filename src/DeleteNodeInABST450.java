/**
 * DeleteNodeInABST450
 *
 * 在二叉搜索树中删除一个结点
 * @author lirongqian
 * @since 2018/03/27
 */
public class DeleteNodeInABST450 {

    public static void main(String[] args) {

    }

    /**
     * 因为二叉搜索树，是排序的树，所以可以利用二分的思想进行查找需要删除的结点
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // 当找到目标结点时，如果左儿子为空，则可以直接将左儿子上移，右儿子类似
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // 如果左右儿子都不为空，则找到右子树中的最小值，然后递归的删除右子树中的最小r
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}