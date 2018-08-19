
/**
 * ReverseLinkedList206
 * 反转链表
 *
 * @author lirongqian
 * @since 2018/05/29
 */
public class ReverseLinkedList206 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            // 保留下一个节点
            ListNode next = head.next;
            // 下一个节点为前一个节点
            head.next = pre;
            // 当前节点为下一次的前一个节点
            pre = head;
            // 将当前节点后移
            head = next;
        }
        return pre;
    }
}