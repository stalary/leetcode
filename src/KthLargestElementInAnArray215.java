import java.util.Arrays;

/**
 * KthLargestElementInAnArray215
 * 数组中第k大的元素
 * @author lirongqian
 * @since 2018/04/11
 */
public class KthLargestElementInAnArray215 {

    public static void main(String[] args) {
        System.out.println(new KthLargestElementInAnArray215().findKthLargest(new int[] {
                3,2,1,5,6,4
        }, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}