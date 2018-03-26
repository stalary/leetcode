
import java.util.ArrayList;
import java.util.List;

/**
 * BinaryTreeRightSideView199
 *
 * 输出在右边可以直接接触到的结点
 * @author lirongqian
 * @since 2018/03/26
 *    1            <---
    /   \
   2     3         <---
    \     \
     5     4       <---
 1，3，4
 */
public class BinaryTreeRightSideView199 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(new BinaryTreeRightSideView199().rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    /**
     * 通过判断该层是否已经存在结点，就可以拿到最外边界的结点
     * @param curr
     * @param result
     * @param currDepth
     */
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        // 当前层和数组中的元素数量相同时，即即代表该元素为当前层最右边的元素
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        // 每次先遍历最右边的元素
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }
}