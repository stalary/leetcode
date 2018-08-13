package binarytree;

/**
 * binarytree.MaximumBinaryTree654
 * <p>
 * 构造一颗最大值的树
 * 每个根都是最大值
 *
 * @author lirongqian
 * @since 2018/03/14
 */
public class MaximumBinaryTree654 {

    public static void main(String[] args) {
        int[] num = new int[] {
                3, 2, 1, 4, 5, 9
        };
        System.out.println(new MaximumBinaryTree654().constructMaximumBinaryTree(num));
    }

    /**
     * 首先找到最大的值作为根，然后左边的元素作为左子树，右边的元素作为右子树，每次根都是最大的
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }
        return help(nums, 0, nums.length - 1);
    }

    public TreeNode help(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // 首先找到最大的值
        int max = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        // 然后开始构造二叉树，每次并且递归查找最大的根
        TreeNode root = new TreeNode(nums[max]);
        root.left = help(nums, start, max - 1);
        root.right = help(nums, max + 1, end);
        return root;
    }
}