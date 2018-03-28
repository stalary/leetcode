
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DistributeCandies575
 *
 * 将数组分为两块，求出最大的不重复部分是多少
 *
 * 首先排序找到最大值和最小值，然后进行打表
 * @author lirongqian
 * @since 2018/03/27
 */
public class DistributeCandies575 {

    public static void main(String[] args) {
        int[] a = new int[]{
                1,1,2,2,2,3
        };
        System.out.println(new DistributeCandies575().distributeCandies1(a));
    }

    public int distributeCandies1(int[] a) {
        // 首先对数组进行排序
        Arrays.sort(a);
        // 申请hash数组，注意负数的情况，当为负数时，数组大小应该为第一个数的绝对值+1，boolean[][2]，0代表负数，1代表正数
        boolean[][] b = new boolean[Math.max(Math.abs(a[0]), a[a.length - 1]) + 1][2];
        for (int i = 0; i < a.length; i++) {
            // 首先判断正负，使用hash，去除重复元素
            if (a[i] >= 0) {
                b[a[i]][1] = true;
            } else {
                b[Math.abs(a[i])][0] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i][1]) {
                count++;
            }
            if (b[i][0]) {
                count++;
            }
        }
        return count < a.length / 2 ? count : a.length / 2;
    }

    /**
     * 使用set来自动去掉重复的值，最大为数组长度的一半
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) {
            kinds.add(candy);
        }
        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
    }
}