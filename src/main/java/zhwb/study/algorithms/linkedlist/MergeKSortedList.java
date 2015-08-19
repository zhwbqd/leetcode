package zhwb.study.algorithms.linkedlist;

import java.util.Comparator;
import java.util.List;
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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0)
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

}
