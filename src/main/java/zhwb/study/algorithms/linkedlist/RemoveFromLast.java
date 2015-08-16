package zhwb.study.algorithms.linkedlist;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * <p/>
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p/>
 * For example,
 * <p/>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p/>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 * @author jack.zhang
 * @since 2015/8/16 0016
 */
public class RemoveFromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode looper = new ListNode(0);
        looper.next = head;

        head = looper;
        ListNode tail = null;
        int count = 0;
        while (head != null) {
            if (count == n)//find the right position. lenth-left = length - right
                tail = looper;//begin from the start
            else if (count > n)
                tail = tail.next;

            ++count;
            head = head.next;
        }

        if (tail != null)
            tail.next = tail.next.next;

        return looper.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        node3.next = new ListNode(5);
        System.out.println(new RemoveFromLast().removeNthFromEnd(node, 2));
    }
}
