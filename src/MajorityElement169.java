import java.util.Arrays;

/**
 * MajorityElement169
 * 超过一半的数字
 * @author lirongqian
 * @since 2018/05/28
 */
public class MajorityElement169 {

    public static void main(String[] args) {
        System.out.println(new MajorityElement169().majorityElement(new int[] {
                2,2,1,1,1,2,2
        }));
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
           if (nums[i] == nums[i - 1]) {
               count++;
               if (count >= nums.length / 2) {
                   return nums[i];
               }
           } else {
               count = 1;
           }
        }
        return -1;
    }

    public int majorityElement1(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        // 哨兵初始化步数1，元素为第一个元素
        int temp = 1;
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            // 步数为0时即切换哨兵
            if (temp == 0) {
                result = array[i];
            }
            // 相同时，哨兵前进，否则后退一步
            if (result == array[i]) {
                temp++;
            } else {
                temp--;
            }
        }
        return result;
    }
}