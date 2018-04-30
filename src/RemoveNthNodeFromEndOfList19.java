
/**
 * RemoveNthNodeFromEndOfList19
 * 删除倒数第n个元素
 * @author lirongqian
 * @since 2018/04/28
 */
public class RemoveNthNodeFromEndOfList19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode first = head;
        ListNode second = root;
        // 找到倒数第n个结点
        while (first != null) {
            // first先移动n，然后second再移动，当first到达末尾时，则找到
            if (n-- <= 0) {
                second = second.next;
            }
            first = first.next;
        }
        // 跳过倒数第n个结点
        second.next = second.next.next;
        return root.next;
    }
}