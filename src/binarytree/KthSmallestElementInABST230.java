package binarytree;

import java.util.Stack;

/**
 * binarytree.KthSmallestElementInABST230
 * <p>
 * 在二叉搜索树中查找第k小的元素
 *
 * @author lirongqian
 * @since 2018/04/02
 */
public class KthSmallestElementInABST230 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        System.out.println(new KthSmallestElementInABST230().kthSmallest(root, 2));
    }

    /**
     * 中序遍历二叉树，去查找元素
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        int count = 0;
        while (temp != null || !stack.isEmpty()) {
            // 找最左节点
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            // 找到最左结点
            temp = stack.pop();
            count++;
            // 已经到达k的，直接输出
            if (count == k) {
                return temp.val;
            }
            // 否则去找右结点，不存在时，则找到根节点
            temp = temp.right;
        }
        return -1;
    }

    /**
     * 首先去搜索左子树，如果超过范围，则将范围减去左子树的结点树，再去搜索右子树
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k) {
        // 因为是从下一个结点开始计算，所以使用时count要+1
        int count = countNodes(root.left);
        // 判断完范围再进行搜索
        if (k <= count) {
            // 查找左子树
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            // 查找右子树
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) {
            return 0;
        }
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}