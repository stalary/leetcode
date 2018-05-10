import java.util.Arrays;

/**
 * ShortestUnsortedContinuousSubarray581
 * 最小需要对多少数排序，组成连续递增序列
 * @author lirongqian
 * @since 2018/05/09
 */
public class ShortestUnsortedContinuousSubarray581 {

    public static void main(String[] args) {
        System.out.println(new ShortestUnsortedContinuousSubarray581().findUnsortedSubarray(new int[] {
                2, 6, 4, 8, 10, 9, 15
        }));
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int start = 0;
        int end = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp[i]) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != temp[i]) {
                end = i;
                break;
            }
        }
        return end - start + 1;
    }
}