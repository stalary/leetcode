package binarytree;

/**
 * ConvertBSTToGreaterTree
 * 将二叉搜索树构造成一颗更大的二叉树
 * 因为为二叉搜索树，所以左儿子一定小于根节点，右儿子一定大于根节点，所以从最后一个右儿子开始相加
 * @author lirongqian
 * @since 2018/03/26
 */
public class ConvertBSTToGreaterTree538 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        TreeNode out = new ConvertBSTToGreaterTree538().convertBST(root);
        System.out.println(out);
    }

    /**
     * Input: The root of a Binary Search Tree like this:
     *               5
     *             /   \
     *            2     13
     *
     * Output: The root of a Greater Tree like this:
     *              18
     *             /   \
     *           20     13
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    /**
     * 因为左儿子肯定是最小的数，而sum是逐渐增大的，所以最后再对左儿子进行递归
     * @param node
     */
    public void convert(TreeNode node) {
        if (node == null) {
            return;
        }
        // 找到最右边的结点，即为最大值
        convert(node.right);
        // 相加
        node.val += sum;
        // 存储节点的值，供下次递归时使用
        sum = node.val;
        convert(node.left);
    }
}