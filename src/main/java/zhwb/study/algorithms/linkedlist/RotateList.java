package zhwb.study.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/rotate-list/
 * <p/>
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p/>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 * @author jack.zhang
 * @since 2015/9/23 0023
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        if (k == 0)
            return head;

        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }

        if (k >= list.size()) {
            if (k % list.size() == 0)
                return head;
            k = k % list.size();
        }

        ListNode oriFirst = list.get(0);
        ListNode newFirst = list.get(list.size() - k);
        ListNode oriTail = list.get(list.size() - 1);
        ListNode newTail = list.get(list.size() - 1 - k);
        newTail.next = null;
        oriTail.next = oriFirst;

        return newFirst;
    }

    public ListNode rotateRightV2(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode copyHead = head;

        int len = 1;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
            len++;
        }

        copyHead.next = head;

        for (int i = len - k % len; i > 1; i--)
            head = head.next;

        copyHead = head.next;
        head.next = null;

        return copyHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(node1);
        System.out.println(new RotateList().rotateRightV2(node1, 2));
    }

}
