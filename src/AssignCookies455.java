
import java.util.Arrays;

/**
 * AssignCookies455
 *
 * 输入两个数组，第一个数组代表每一个孩子的贪婪系数，第二个数组代表每一个饼干的大小，若饼干大小可以满足该孩子的贪婪系数，则数量加1
 * 每个孩子仅能分配一个饼干
 * @author lirongqian
 * @since 2018/03/23
 */
public class AssignCookies455 {

    public static void main(String[] args) {
        int[] g = new int[] {
                10, 9, 8, 7
        };
        int[] s = new int[] {
             5, 6, 7, 8
        };
        System.out.println(findContentChildren(g, s));
    }

    /**
     * Input: [1,2,3], [1,1]
     *
     * Output: 1
     *
     * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
     * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
     * You need to output 1.
     */
    /**
     * Input: [1,2], [1,2,3]
     *
     * Output: 2
     *
     * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
     * You have 3 cookies and their sizes are big enough to gratify all of the children,
     * You need to output 2.
     * 当饼干比贪婪系数大时，既满足
     */
    /**
     * 先使用最小贪婪的孩子和最小饼干进行比较，如果最小的饼干满足，则进行找更大的孩子和饼干，若不满足则找更大的饼干
     * 首先对两个数组进行排序，然后使用一个代表孩子的下标变量，匹配成功，后移一次，最后返回该下标
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                i++;
            }
        }
        return i;
    }
}