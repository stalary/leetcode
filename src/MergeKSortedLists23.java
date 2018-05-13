import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * MergeKSortedLists23
 * 合并k个排序list
 *
 * @author lirongqian
 * @since 2018/05/13
 */
public class MergeKSortedLists23 {

    /**
     * 使用优先队列进行存储
     * 首先构建一个头结点
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) {
                heap.offer(tail.next);
            }
        }
        return head.next;
    }
}