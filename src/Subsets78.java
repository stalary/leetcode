import java.util.ArrayList;
import java.util.List;

/**
 * Subsets78
 * 返回所有子集
 *
 * @author lirongqian
 * @since 2018/04/05
 */
public class Subsets78 {

    public static void main(String[] args) {
        System.out.println(new Subsets78().subsets(new int[]{
                1, 2, 3
        }));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        subsets(nums, 0, res, new ArrayList<>());
        return res;
    }

    /**
     * 当当前下标等于长度时，代表完成了一次排列
     * @param nums
     * @param index
     * @param res
     * @param subset
     */
    public void subsets(int[] nums, int index, List<List<Integer>> res, List<Integer> subset) {
        if (index == nums.length) {
            res.add(subset);
            return;
        }
        // 每次向后添加一个元素，递归
        subsets(nums, index + 1, res, subset);
        ArrayList<Integer> list = new ArrayList<>(subset);
        list.add(nums[index]);
        subsets(nums, index + 1, res, list);
    }

}