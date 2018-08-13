package binarytree;

/**
 * binarytree.FlattenBinaryTreeToLinkedList114
 * 将二叉树转为只有右节点的二叉树
 * @author lirongqian
 * @since 2018/04/16
 */
public class FlattenBinaryTreeToLinkedList114 {

    public void flatten(TreeNode root) {
        flatten(root, null);
    }

    /**
     * 首先获取最右节点
     * 然后依次将当前节点放到父节点的右侧，并且清空左结点
     * @param root
     * @param pre
     * @return
     */
    private TreeNode flatten(TreeNode root, TreeNode pre) {
        if (root == null) {
            return pre;
        }
        pre = flatten(root.right, pre);
        pre = flatten(root.left, pre);
        // 将左节点赋值给右节点，然后左节点清空
        root.right = pre;
        root.left = null;
        pre = root;
        return pre;
    }
}