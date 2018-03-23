
/**
 * AddOneRowToTree623
 * <p>
 * 向二叉树中的指定深度插入指定的结点
 *
 * @author lirongqian
 * @since 2018/03/19
 */
public class AddOneRowToTree623 {

    public static void main(String[] args) {

    }

    /**
     * 可以先假定1为添加左子树，0为添加右子树，通过递归即可完成结点的添加
     * 因为当d为2时即加在根结点左右儿子上，所以可以巧妙的运用2来判断是否需要加入
     *
     * @param root
     * @param v
     * @param d
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 0 || d == 1) {
            TreeNode newroot = new TreeNode(v);
            newroot.left = d == 1 ? root : null;
            newroot.right = d == 0 ? root : null;
            return newroot;
        }
        // 当大于等于2时，添加左子树和右子树
        if (root != null && d >= 2) {
            root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
            root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
        }
        return root;
    }

    /**
     * 使用广搜的方法，当d为1时，即将原结点作为左结点放入
     *
     * @param t
     * @param v
     * @param d
     * @return
     */
    public TreeNode addOneRow1(TreeNode t, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = t;
            return n;
        }
        insert(t, v,1, d);
        return t;
    }

    public void insert(TreeNode node, int val, int depth, int n) {
        if (node == null) {
            return;
        }
        if (depth == n - 1) {
            // 当深度达到d时，则将左右结点插入目标结点值
            TreeNode t = node.left;
            node.left = new TreeNode(val);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNode(val);
            node.right.right = t;
        } else {
            // 递归的遍历左右儿子，广搜，深度+1
            insert(node.left, val,depth + 1, n);
            insert(node.right, val, depth + 1, n);
        }
    }
}