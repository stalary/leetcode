import java.util.ArrayList;
import java.util.List;

/**
 * Subsets78
 * 返回所有子集
 * @author lirongqian
 * @since 2018/04/05
 */
public class Subsets78 {

    public static void main(String[] args) {
        System.out.println(new Subsets78().subsets(new int[] {
                1, 2, 3
        }));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        help(nums, new ArrayList<>(), lists, 0);
        return lists;
    }

    /**
     * 先依次加入所有元素，然后每次删除最后一个元素
     * @param nums
     * @param tempList
     * @param lists
     * @param index
     */
    public void help(int[] nums, List<Integer> tempList, List<List<Integer>> lists, int index) {
        lists.add(new ArrayList<>(tempList));
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            help(nums, tempList, lists, i + 1);
            // 元素归位
            tempList.remove(tempList.size() - 1);
        }
    }

}