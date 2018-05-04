/**
 * LinkedListCycleII142
 * 找到环形list的入口，如果没有环返回null
 *
 * @author lirongqian
 * @since 2018/05/04
 */
public class LinkedListCycleII142 {

    /**
     * 首先使用快慢指针，判断是否有环
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (slow == fast) {
                break;
            }
        }
        // 存在null时代表无环
        if (slow == null || fast == null) {
            return null;
        }
        // 将fast指针重置，当与相遇点再次相遇时
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}