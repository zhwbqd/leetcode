package zhwb.study.algorithms.linkedlist;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Reverse a singly linked list.
 *
 * Date: 15/7/12
 * Time: 下午9:42
 *
 * @author jack.zhang
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseListV2(ListNode head) {
        ListNode first = null;
        ListNode tail = head;
        while (tail != null) {
            ListNode tmp = tail;
            tail = tail.next;
            tmp.next = first;
            first = tmp;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next = new ListNode(3);
        node.next = new ListNode(4);
    }
}

