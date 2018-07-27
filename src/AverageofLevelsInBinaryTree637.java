import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * AverageofLevelsInBinaryTree637
 *
 * 求二叉树每一层的平均值
 *
 * @author lirongqian
 * @since 2018/03/23
 */
public class AverageofLevelsInBinaryTree637 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        List<Double> list = new AverageofLevelsInBinaryTree637().averageOfLevels1(treeNode);
        for (double out : list) {
            System.out.print(out + " ");
        }
    }

    /**
     * 第一种思路：
     * 将二叉树每一层存入队列中进行计算
     * 相当于二叉树的层序遍历
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return list;
        }
        q.add(root);
        while (!q.isEmpty()) {
            // 第一次q只有root一个元素
            int n = q.size();
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                // 拿出根结点
                TreeNode node = q.poll();
                sum += node.val;
                // 此时加入非空的左儿子和右儿子，n的数量随之增长
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            // 求出当前层的平均值
            list.add(sum / n);
        }
        return list;
    }

    /**
     * 第二种思路：
     * 使用dfs
     *
     */
    public List<Double> averageOfLevels1(TreeNode root) {
        // 计算每层的值
        List<Double> answer = new ArrayList<>();
        // 计算每层的结点数
        List<Integer> counter = new ArrayList<>();
        dfs(0, root, answer, counter);
        // 将answer除以总数
        for (int level = 0; level < answer.size(); level++) {
            answer.set(level, answer.get(level) / counter.get(level));
        }
        return answer;
    }

    public void dfs(int level, TreeNode node, List<Double> answer, List<Integer> counter) {
        if (node == null) {
            return;
        }
        // 初始化两个链表
        if (answer.size() <= level) {
            answer.add(0.0);
            counter.add(0);
        }
        // 添加当前结点的值
        answer.set(level, answer.get(level) + node.val);
        // 增加桶的数量
        counter.set(level, counter.get(level) + 1);
        // 继续添加左右结点
        dfs(level + 1, node.left, answer, counter);
        dfs(level + 1, node.right, answer, counter);
    }
}