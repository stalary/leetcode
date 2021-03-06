package binarytree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * binarytree.ValidateBinarySearchTree98
 * 判断是不是二叉搜索树
 *
 * @author lirongqian
 * @since 2018/05/17
 */
public class ValidateBinarySearchTree98 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine();
        String[] split = inStr.split(",");
        List<Integer> inList = Arrays.stream(split).map(Integer::new).collect(Collectors.toList());
        Integer[] integers = inList.toArray(new Integer[]{});
        TreeNode tree = createBinaryTreeByArray(integers, 0);
        System.out.println(isValidBST(tree) ? "True" : "False");
    }

    private static TreeNode createBinaryTreeByArray(Integer[] array, int index) {
        TreeNode treeNode = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                // null不插入
                return null;
            }
            treeNode = new TreeNode(value);
            treeNode.left = createBinaryTreeByArray(array, 2 * index + 1);
            treeNode.right = createBinaryTreeByArray(array, 2 * index + 2);
            return treeNode;
        }
        return treeNode;
    }

    /**
     * 中序遍历的变形
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            // 找最左节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 找到根节点
            root = stack.pop();
            // 判断是否符合二叉搜索树，当前一个节点大时，直接返回false
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            // 记录前一个节点
            pre = root;
            // 遍历右节点
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        // 当前元素不满足条件时跳出
        if (root.val >= max || root.val <= min) {
            return false;
        }
        // 左节点小，右节点大
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}