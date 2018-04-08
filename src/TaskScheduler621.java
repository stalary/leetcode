/**
 * TaskScheduler621
 * 计算任务时间
 * @author lirongqian
 * @since 2018/04/08
 */
public class TaskScheduler621 {

    public static void main(String[] args) {
        System.out.println(new TaskScheduler621().leastInterval(new char[]{
                'A', 'A', 'A', 'B', 'B', 'B'
        }, 2));
    }


    /**
     * 首先找到出现次数最多的字母
     * 然后查找是否有和次数最多的字母数量相同的
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        int max = 0;
        int repeat = 0;
        for (char a : tasks) {
            int i = a - 'A';
            if (++arr[i] > max) {
                repeat = 1;
                max = arr[i];
            } else if (arr[i] == max) {
                repeat++;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + repeat);
    }

}