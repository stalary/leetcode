/**
 * FindTheDuplicateNumber287
 * 查找重复的元素
 * @author lirongqian
 * @since 2018/04/06
 */
public class FindTheDuplicateNumber287 {

    public static void main(String[] args) {
        System.out.println(new FindTheDuplicateNumber287().findDuplicate(new int[]{
                1, 3, 2, 1
        }));
    }

    /**
     * 利用桶的思想，将已经出现过的加上数组的长度，这样再次出现时即代表出现重复元素
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (index >= nums.length) {
                index -= nums.length;
            }
            if (nums[index] >= nums.length) {
                return index;
            }
            nums[index] += nums.length;
        }
        return -1;
    }

    /**
     * 因为题目说一定会出现重复的数字，而且数字范围为1-n，所以可以申请两个快慢指针
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        // 申请快慢指针
        int slow = nums[0];
        int fast = nums[0];
        do {
            // 移动到当前数字下标所对应的数组
            slow = nums[slow];
            // 移动到当前数字下标所对应的数组后再移动到该数所对应的下标的数组
            fast = nums[nums[fast]];
        } while (slow != fast);
        // 当快慢指针相遇时，申请一个位于起始位置的指针和一个位于慢指针位置的指针
        int ptr1 = nums[0];
        int ptr2 = slow;
        // 当相遇时即代表有重复元素
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}