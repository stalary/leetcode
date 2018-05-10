import java.util.LinkedList;
import java.util.List;

/**
 * TheSkylineProblem218
 * 求出给定建筑物的轮廓
 *
 * @author lirongqian
 * @since 2018/05/10
 */
public class TheSkylineProblem218 {

    public static void main(String[] args) {
        System.out.println(new TheSkylineProblem218().getSkyline(new int[][]{
                {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
        }));
    }

    /**
     * 使用分治的思想
     *
     * @param buildings
     * @return
     */
    public List<int[]> getSkyline(int[][] buildings) {
        return merge(buildings, 0, buildings.length - 1);
    }

    private LinkedList<int[]> merge(int[][] buildings, int lo, int hi) {
        LinkedList<int[]> res = new LinkedList<>();
        if (lo > hi) {
            return res;
        } else if (lo == hi) {
            // 存入最高点和最低点，最低点一定纵坐标为0
            res.add(new int[]{buildings[lo][0], buildings[lo][2]});
            res.add(new int[]{buildings[lo][1], 0});
            return res;
        }
        int mid = lo + (hi - lo) / 2;
        // 将建筑物分成左右两个子集
        LinkedList<int[]> left = merge(buildings, lo, mid);
        LinkedList<int[]> right = merge(buildings, mid + 1, hi);
        int leftH = 0, rightH = 0;
        while (!left.isEmpty() || !right.isEmpty()) {
            long x1 = left.isEmpty() ? Long.MAX_VALUE : left.peekFirst()[0];
            long x2 = right.isEmpty() ? Long.MAX_VALUE : right.peekFirst()[0];
            int x = 0;
            if (x1 < x2) {
                // 当左边小时，拉出左边的数组
                int[] temp = left.pollFirst();
                x = temp[0];
                leftH = temp[1];
            } else if (x1 > x2) {
                int[] temp = right.pollFirst();
                x = temp[0];
                rightH = temp[1];
            } else {
                // 相同时则左右高度都要获取
                x = left.peekFirst()[0];
                leftH = left.pollFirst()[1];
                rightH = right.pollFirst()[1];
            }
            // 获取左右的最大高度
            int h = Math.max(leftH, rightH);
            // 当不存在时加入
            if (res.isEmpty() || h != res.peekLast()[1]) {
                res.add(new int[]{x, h});
            }
        }
        return res;
    }
}