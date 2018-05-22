import java.util.*;

/**
 * QueueReconstructionByHeight406
 * 将乱序的队列按一定算法排序
 *
 * Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * @author lirongqian
 * @since 2018/04/03
 */
public class QueueReconstructionByHeight406 {

    public static void main(String[] args) {
        int[][] people = new int[][] {
                {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        };
        System.out.println(Arrays.deepToString(new QueueReconstructionByHeight406().reconstructQueue(people)));
    }

    /**
     * 排序的规则为，当两个数组的第一个数不同时，较大的放在前面，相同时，第二个数较小的放在前面
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        // [[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]]
        Arrays.sort(people, (p1, p2) -> p1[0] != p2[0] ? Integer.compare(p2[0], p1[0]) : Integer.compare(p1[1], p2[1]));
        // [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
        List<int[]> list = new LinkedList<>();
        // 前面有几个元素就放到第几个
        for (int[] ppl : people) {
            list.add(ppl[1], ppl);
        }
        return list.toArray(new int[people.length][]);
    }
}