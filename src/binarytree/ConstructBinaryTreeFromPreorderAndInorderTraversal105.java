package binarytree;

/**
 * binarytree.ConstructBinaryTreeFromPreorderAndInorderTraversal105
 * 通过前序和中序构建二叉树
 * @author lirongqian
 * @since 2018/04/20
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode help(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        int value = preorder[ps];
        int index = is;
        while (index < ie && inorder[index] != value) {
            index++;
        }
        TreeNode root = new TreeNode(value);
        root.left = help(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
        root.right = help(preorder, ps + index -is + 1, pe, inorder, index + 1, ie);
        return root;
    }
}