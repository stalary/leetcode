import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * SlidingWindowMaximum239
 * 滑动窗口的最大值
 * @author lirongqian
 * @since 2018/04/21
 */
public class SlidingWindowMaximum239 {

    public int[] maxSlidingWindow(int[] num, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (k == 0) {
            return new int[]{};
        }
        // start为开始的下标，当下标为0时，才代表完成了第一个窗口的组装，所以start的初始值为i - size + 1
        int start;
        for (int i = 0; i < num.length; i++) {
            start = i - k + 1;
            // 当队列为空时，直接加入下标
            if (deque.isEmpty()) {
                deque.add(i);
                // 当队列不为空时，需要判断最前面的值是否还在窗口中，不再窗口中则移除
            } else if (start > deque.peekFirst()) {
                deque.pollFirst();
            }
            // 当队列不为空，并且当前值大于等于队列最后一下下标所对应的值时，则将最后一个下标出队
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }
            // 当当前值比队列中最后一个下标所对应的值小的时候，则入队
            deque.add(i);
            // 等于0时，代表已经组装完成第一个窗口，大于0则为窗口向后移动，每次移动都会加入一个最大值
            if (start >= 0) {
                result.add(num[deque.peekFirst()]);
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}