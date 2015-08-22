package zhwb.study.algorithms.linkedlist;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * <p/>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p/>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p/>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 * @author jack.zhang
 * @since 2015/8/22 0022
 */
public class SwapNodePairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;

        return newHead;
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

        System.out.println(new SwapNodePairs().swapPairs(node));
    }
}
