import java.util.HashSet;
import java.util.Set;

/**
 * IntersectionOfTwoArrays349
 *
 * 返回两个数组的交集，而且是非重复元素，所以可以使用set进行去重
 * @author lirongqian
 * @since 2018/04/01
 */
public class IntersectionOfTwoArrays349 {

    public static void main(String[] args) {
        int[] nums1 = new int[] {
                1,2,2,1
        };
        int[] nums2 = new int[] {
                2,2
        };
        int[] out = intersection(nums1, nums2);
        for (int n : out) {
            System.out.print(n + " ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        if (nums1.length >= nums2.length) {
            for (int n : nums1) {
                set.add(n);
            }
            for (int n : nums2) {
                if (set.contains(n)) {
                    temp.add(n);
                }
            }
        } else {
            for (int n : nums2) {
                set.add(n);
            }
            for (int n : nums1) {
                if (set.contains(n)) {
                    temp.add(n);
                }
            }
        }
        int[] out = new int[temp.size()];
        int i = 0;
        for (Integer n : temp) {
            out[i++] = n;
        }
        return out;
    }
}