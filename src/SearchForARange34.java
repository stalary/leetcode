/**
 * SearchForARange34
 * 从一个递增数组中查找一个目标值的开始和结束的点
 * @author lirongqian
 * @since 2018/05/02
 */
public class SearchForARange34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[] {
                getFirst(nums, target),
                getLast(nums, target)
        };
    }

    public int getFirst(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (mid - 1 >= 0 && nums[mid - 1] == target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int getLast(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (mid + 1 < len && nums[mid + 1] == target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}