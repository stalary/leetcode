package binarytree;

/**
 * BinaryTreeTilt
 *
 * 求二叉树的倾斜度
 * Input:
    1
  /   \
 2     3
 Output: 1
 Explanation:
 Tilt of node 2 : 0
 Tilt of node 3 : 0
 Tilt of node 1 : |2-3| = 1
 Tilt of binary tree : 0 + 0 + 1 = 1

 * @author lirongqian
 * @since 2018/03/26
 */
public class BinaryTreeTilt563 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(5);
        findTilt(node);
        System.out.println(sum);
    }

    /**
     * 相当于求左右儿子的差
     */
    static int sum = 0;
    public static int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        // 求绝对值
        sum += Math.abs(left - right);
        return left + right + root.val;
    }

}