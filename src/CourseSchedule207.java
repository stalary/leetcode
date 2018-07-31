import java.util.LinkedList;
import java.util.Queue;

/**
 * CourseSchedule207
 * 课程表，求课程表是否可能
 *
 * @author lirongqian
 * @since 2018/04/29
 */
public class CourseSchedule207 {

    public static void main(String[] args) {
        System.out.println(canFinish(3, new int[][] {
                {1, 0}, {2, 1}
        }));
    }

    /**
     * Input: 2, [[1,0]]
     * Output: true
     * Explanation: 完成1之前需要完成0
     *
     * Input: 2, [[1,0],[0,1]]
     * Output: false
     * Explanation: 完成1之前要完成0，完成0之前要完成1所以不可能实现
     *
     * 判断所有的
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        // 构建入边
        for (int i = 0; i < prerequisites.length; i++) {
            // 前置条件
            inDegree[prerequisites[i][1]]++;
        }
        for (int i = 0; i < inDegree.length; i++) {
            // 不存在前置时直接存入队列，用于消除边
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (x == prerequisites[i][0]) {
                    // 找到前置时进行--
                    inDegree[prerequisites[i][1]]--;
                    // 当边为0时，加入任务，继续进行入边判断
                    if (inDegree[prerequisites[i][1]] == 0) {
                        queue.offer(prerequisites[i][1]);
                    }
                }
            }
        }
        for (int i = 0; i < inDegree.length; i++) {
            // 当仍然存在边时即不满足条件
            if (inDegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}