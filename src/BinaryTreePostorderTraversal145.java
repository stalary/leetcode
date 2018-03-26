import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * BinaryTreePostorderTraversal145
 * <p>
 * 后序打印二叉树
 *
 * @author lirongqian
 * @since 2018/03/26
 */
public class BinaryTreePostorderTraversal145 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new BinaryTreePostorderTraversal145().postorderTraversal(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return ans;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            // 根要最后在遍历，所以每次都要往头放，最后压到底部
            ans.addFirst(cur.val);
            // 虽然栈弹出的顺序是与遍历顺序相反，但是因为每次放入list中是放在头部，所以此处左结点先入栈
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }
}