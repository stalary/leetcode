import java.util.*;

/**
 * MinStack155
 * 可以返回最小值的栈
 *
 * @author lirongqian
 * @since 2018/05/04
 */
public class MinStack155 {

    public static void main(String[] args) {

    }

    /**
     * 使用list来存储数据，使用heap来存储最小值的顺序
     */
    /*int size;
    Integer min;
    private PriorityQueue<Integer> minHeap;
    List<Integer> list;

    public MinStack155() {
        min = Integer.MAX_VALUE;
        size = 0;
        minHeap = new PriorityQueue<>();
        list = new ArrayList<>();
    }

    public void push(int x) {
        size++;
        if (x < min) {
            min = x;
        }
        minHeap.offer(x);
        list.add(x);
    }

    public void pop() {
        if (size > 0) {
            if (list.get(size - 1).equals(min)) {
                minHeap.poll();
                min = minHeap.peek();
            }
            list.remove(size - 1);
            size--;
        }
    }

    public Integer top() {
        if (size > 0) {
            return list.get(size - 1);
        }
        return null;
    }

    public Integer getMin() {
        return min;
    }
    */

    private Node head;

    public void push(int x) {
        if (head == null) {
            // 当head为空时，存储当前值，并设置为最小值
            head = new Node(x, x);
        } else {
            // 不为空时，将当前值放到首位，并判断最小值
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        // 弹出首位
        head = head.next;
    }

    public int top() {
        // 输出当前值
        return head.val;
    }

    public int getMin() {
        // 获取最小值
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}