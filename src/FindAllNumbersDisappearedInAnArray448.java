import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * FindAllNumbersDisappearedInAnArray448
 *
 * 在1-n中找到数组中不存在的元素，我们可以顺序查找，将每次找到的元素对应的下标设为负数
 * 当第二次遍历时，将正数存入list中返回
 * @author lirongqian
 * @since 2018/03/27
 */
public class FindAllNumbersDisappearedInAnArray448 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                4, 3, 2, 7, 8, 2, 3, 1
        };
        System.out.println(new FindAllNumbersDisappearedInAnArray448().findDisappearedNumbers1(nums));
    }

    /**
     * 使用类似于打表的方法，将出现过的数字作为下标存入，设为负数
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int len = nums.length;
        boolean[] arr = new boolean[len + 1];
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            arr[num] = true;
        }
        for (int i = 1; i <= len; i++) {
            if (!arr[i]) {
                list.add(i);
            }
        }
        return list;
    }
}