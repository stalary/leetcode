import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * 返回数字的全排列
 *
 * @author lirongqian
 * @since 2018/04/05
 */
public class Permutations46 {

    public static void main(String[] args) {
        System.out.println(new Permutations46().permute(new int[]{
                1, 2, 3
        }));
    }

    public List<List<Integer>> permute1(int[] num) {
        List<List<Integer>> ans = new ArrayList<>();
        if (num.length == 0) {
            return ans;
        }
        // 首先存入第一个元素进行固定
        ans.add(new ArrayList<>(num[0]));
        // 从第二个元素开始排序
        for (int i = 1; i < num.length; ++i) {
            List<List<Integer>> lists = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                for (List<Integer> l : ans) {
                    List<Integer> list = new ArrayList<>(l);
                    // 每次向不同的位置进行插入
                    list.add(j, num[i]);
                    lists.add(list);
                }
            }
            ans = lists;
        }
        return ans;
    }

    /**
     * 首先将第一个元素与其他元素进行交换
     * 然后将被交换元素锁定，继续交换，即完成了全排序
     * abc
     * abc     bac      cba    将a与b交换，a与c交换
     * abc  cba bac bca  cba  cab
     *
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        help(nums, 0, lists);
        return lists;
    }

    public void help(int[] nums, int index, List<List<Integer>> lists) {
        if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            // 去除全排列中的重复元素
            if (!lists.contains(list)) {
                lists.add(list);
            }
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(nums, index, i);
                // 进行全排列下一个元素
                help(nums, index + 1, lists);
                // 元素归位
                swap(nums, index, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}