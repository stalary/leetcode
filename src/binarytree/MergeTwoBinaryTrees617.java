package binarytree;

/**
 * binarytree.MergeTwoBinaryTrees617
 *
 * 合并两个二叉树
 * @author lirongqian
 * @since 2018/03/19
 */
public class MergeTwoBinaryTrees617 {

    /**
     * 当左侧二叉树为空时，则使用右侧的二叉树，不为空时，则进行相加
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return  t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

}