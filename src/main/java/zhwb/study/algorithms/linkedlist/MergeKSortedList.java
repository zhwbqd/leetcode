package zhwb.study.algorithms.linkedlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * <p/>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * @author jack.zhang
 * @since 2015/8/19 0019
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(11, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (ListNode node : lists) {
            if (node != null)
                queue.add(node);
        }
        if (queue.isEmpty())
            return null;

        ListNode result = queue.poll();
        if (result.next != null)
            queue.add(result.next);

        ListNode cur = result;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.add(node.next);
                node.next = null;
            }
            cur.next = node;
            cur = cur.next;
        }

        return result;
    }

    public ListNode mergeKListsV2(ListNode[] lists) {
        int length = lists.length;

        if (length == 0)
            return null;
        if (length == 1) {
            return lists[0];
        }

        int mid = (length - 1) / 2;
        ListNode l1 = mergeKLists(Arrays.copyOfRange(lists, 0, mid + 1));
        ListNode l2 = mergeKLists(Arrays.copyOfRange(lists, mid + 1, length));

        return mergeTwoLists(l1, l2);
    }

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

        System.out.println(new MergeKSortedList().mergeKListsV2(new ListNode[]{node, node0}));
    }

}
