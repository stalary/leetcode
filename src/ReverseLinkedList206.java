
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
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}