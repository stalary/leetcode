
/**
 * LinkedListCycle141
 * 判断一个LinkedList是否有环
 * @author lirongqian
 * @since 2018/04/02
 */
public class LinkedListCycle141 {

    /**
     * 利用快慢指针，判断是否有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            // 相遇时即有环
            if (slow != fast) {
                if (fast != null) {
                    fast = fast.next;
                } else {
                    // 当未相遇，但是快指针到了尽头时，代表无环
                    return false;
                }
            }
        }
        return false;
    }
}