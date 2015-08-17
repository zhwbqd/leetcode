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
        ListNode node1 = new ListNode(2);
        node.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        node3.next = new ListNode(5);
        System.out.println(new ReverseLinkedList().reverseList(node));
    }
}

