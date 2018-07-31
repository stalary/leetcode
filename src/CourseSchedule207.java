import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * CourseSchedule207
 * 求图是否有环
 *
 * @author lirongqian
 * @since 2018/04/29
 */
public class CourseSchedule207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建图
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        // 初始化图
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        // 将出现的课程添加
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[1]]++;
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        // 将入度为0的添加
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        // 计算出度
        while (queue.size() != 0) {
            int course = queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int pointer = (int) graph[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                    count++;
                }
            }
        }
        // count等于课程数量时返回true
        if (count == numCourses) {
            return true;
        } else {
            return false;
        }
    }
}