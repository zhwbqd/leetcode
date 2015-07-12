package zhwb.study.algorithms.reverse;

/**
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

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
