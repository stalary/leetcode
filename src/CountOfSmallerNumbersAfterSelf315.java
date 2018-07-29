import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CountOfSmallerNumbersAfterSelf315
 * 求右边当前数字小的数量
 *
 * @author lirongqian
 * @since 2018/04/18
 */
public class CountOfSmallerNumbersAfterSelf315 {

    public static void main(String[] args) {
        System.out.println(new CountOfSmallerNumbersAfterSelf315().countSmaller(new int[]{
                5, 2, 6, 1
        }));
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            ans[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(ans);
    }

    private int findIndex(List<Integer> sorted, int target) {
        if (sorted.size() == 0) {
            return 0;
        }
        int start = 0;
        int end = sorted.size() - 1;
        if (sorted.get(end) < target) {
            return end + 1;
        }
        if (sorted.get(start) >= target) {
            return 0;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (sorted.get(start) >= target) {
            return start;
        }
        return end;
    }
}