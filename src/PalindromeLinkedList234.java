/**
 * PalindromeLinkedList234
 * 判断一个ListNode是否时回文，时间复杂度控制在O(n)
 * @author lirongqian
 * @since 2018/04/29
 */
public class PalindromeLinkedList234 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(3);
        root.next.next = new ListNode(5);
        root.next.next.next = new ListNode(7);
        System.out.println(new PalindromeLinkedList234().reverse(root));
    }

    /**
     * 使用快慢指针，可以找到中点，
     * 然后对后半部分逆置
     * slow指针和fast指针一起移动，当有不相同元素时则表示不满足回文
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        // 申请快慢指针，快指针每次移动两个
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 当奇数时，让右边的小于一半
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    // 倒置
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            // 下一个结点
            ListNode next = head.next;
            // 下一个节点等于前一个结点
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 移动到倒数第二个元素，获取当前链表
        ListNode node = reverse1(head.next);
        // 下下个元素设置为当前结点(跳过末尾结点)
        head.next.next = head;
        // 断开与之前结点的关联
        head.next = null;
        return node;
    }
}