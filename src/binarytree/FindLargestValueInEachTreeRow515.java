package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * binarytree.FindLargestValueInEachTreeRow515
 * <p>
 * 找出每一层的最大值
 *
 * @author lirongqian
 * @since 2018/03/27
 */
public class FindLargestValueInEachTreeRow515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int d) {
        if (root == null) {
            return;
        }
        //扩展list
        if (d == res.size()) {
            res.add(root.val);
        } else {
            // 向当前层存入最大值，此时，当前层已经至少存在一个元素
            res.set(d, Math.max(res.get(d), root.val));
        }
        // 递归查找左右子结点
        helper(root.left, res, d + 1);
        helper(root.right, res, d + 1);
    }
}