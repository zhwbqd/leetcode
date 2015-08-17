package zhwb.study.algorithms.linkedlist;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * <p/>
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * @author jack.zhang
 * @since 2015/8/17 0017
 */
public class MergeTwoSortedLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l2.next, l1);
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(3);
        node.next = node1;
        ListNode node2 = new ListNode(5);
        node1.next = node2;
        ListNode node3 = new ListNode(7);
        node2.next = node3;
        node3.next = new ListNode(9);

        ListNode node0 = new ListNode(1);
        ListNode node01 = new ListNode(4);
        node0.next = node01;
        ListNode node02 = new ListNode(6);
        node01.next = node02;
        ListNode node03 = new ListNode(8);
        node02.next = node03;
        node03.next = new ListNode(10);

        System.out.println(new MergeTwoSortedLinkedList().mergeTwoLists(node, node0));
    }
}
