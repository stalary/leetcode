
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * BinaryTreePaths257
 * <p>
 * 输入一颗二叉树，输出所有从根出发的路径
 *
 * @author lirongqian
 * @since 2018/03/26
 *
 */
public class BinaryTreePaths257 {

    public static void main(String[] args) {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null) {
            searchBT(root, "", answer);
        }
        return answer;
    }

    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) {
            // 当左右儿子都为空时，将路径添加到list里
            answer.add(path + root.val);
        }
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", answer);
        }
        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", answer);
        }
    }

    public List<String> binaryTreePaths1(TreeNode root) {

        List<String> paths = new LinkedList<>();

        if (root == null) {
            return paths;
        }

        if (root.left == null && root.right == null) {
            paths.add(root.val + "");
            return paths;
        }

        for (String path : binaryTreePaths1(root.left)) {
            paths.add(root.val + "->" + path);
        }

        for (String path : binaryTreePaths1(root.right)) {
            paths.add(root.val + "->" + path);
        }
        return paths;
    }
}