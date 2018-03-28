/**
 * DeleteNodeInALinkedList237
 *
 * 删除链表中的结点
 * @author lirongqian
 * @since 2018/03/27
 */
public class DeleteNodeInALinkedList237 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        deleteNode(node.next.next);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }

    public static void deleteNode(ListNode node) {
        // 将结点整体后移即可
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}