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