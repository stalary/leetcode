
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * BinaryTreePostorderTraversal145
 *
 * 倒序打印二叉树
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
        TreeNode temp = root;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            for (; root.left != null; root = root.left) {
                stack.push(root);
            }
            while (root != null && (root.right == null || root.right == temp)) {
                list.add(root.val);
                temp = root;
                if (stack.empty()) {
                    return list;
                }
                root = stack.pop();
            }
            if (root != null) {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }
}