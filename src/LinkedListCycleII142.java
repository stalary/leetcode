/**
 * LinkedListCycleII142
 * 找到环形list的入口，如果没有环返回null
 * @author lirongqian
 * @since 2018/05/04
 */
public class LinkedListCycleII142 {

    public ListNode detectCycle(ListNode head) {
        ListNode meetNode = meetNode(head);
        if (meetNode == null) {
            return null;
        }
        // 统计环内元素数量
        int count = 1;
        ListNode p1 = meetNode;
        while (p1.next != meetNode) {
            p1 = p1.next;
            count++;
        }
        p1 = head;
        for (int i = 0; i < count; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    /**
     * 使用快慢指针查找相遇点
     * @param head
     * @return
     */
    public ListNode meetNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            if (slow != fast) {
                fast = fast.next;
            }
        }
        return null;
    }
}