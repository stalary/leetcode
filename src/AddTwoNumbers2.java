/**
 * AddTwoNumbers2
 * 将两个ListNode的数字倒置，相加，再倒置拆分为一个ListNode
 * @author lirongqian
 * @since 2018/05/13
 */
public class AddTwoNumbers2 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        System.out.println(new AddTwoNumbers2().addTwoNumbers(node1, node2));
    }

    /**
     * 直接相加会产生溢出，所以使用carry来保存进位，逐位相加
     * 相当于直接正向相加，在加上进位
     * @param l1
     * @param l2
     * @return
     */
    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            System.out.println("x: " + x);
            System.out.println("y: " + y);
            int sum = carry + x + y;
            // 进位值
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        // 最后的进位
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}