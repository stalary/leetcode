/**
 * IntersectionOfTwoLinkedLists160
 * 求两个list的交叉开始的结点
 *
 * @author lirongqian
 * @since 2018/05/04
 */
public class IntersectionOfTwoLinkedLists160 {

    public static void main(String[] args) {
            ListNode node1 = new ListNode(1);
            node1.next = new ListNode(3);
            node1.next.next = new ListNode(5);
            ListNode node2 = new ListNode(5);
        System.out.println(new IntersectionOfTwoLinkedLists160().getIntersectionNode(node1, node2));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 边界检测
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        // 当a和b不同时，依此向后遍历直到找到相同的结点
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}