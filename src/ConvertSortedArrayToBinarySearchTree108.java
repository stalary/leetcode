
/**
 * ConvertSortedArrayToBinarySearchTree108
 *
 * 将一个排好序的数组转化为一颗二叉搜索树
 * @author lirongqian
 * @since 2018/03/26
 */
public class ConvertSortedArrayToBinarySearchTree108 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                -10, -3, 0, 5, 9
        };
        TreeNode node = sortedArrayToBST(nums);
        System.out.println(node);
    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return help(nums, 0, nums.length - 1);
    }

    /**
     * 每次取中点，代表根节点，然后依次取左儿子和右儿子进行赋值
     * @param nums
     * @param low
     * @param high
     * @return
     */
    public static TreeNode help(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (high + low) / 2;
        // 将中点作为根
        TreeNode node = new TreeNode(nums[mid]);
        // 分别构造左右结点
        node.left = help(nums, low, mid - 1);
        node.right = help(nums, mid + 1, high);
        return node;
    }
}