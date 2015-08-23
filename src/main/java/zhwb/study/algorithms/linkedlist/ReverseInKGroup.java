package zhwb.study.algorithms.linkedlist;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * <p/>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p/>
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p/>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p/>
 * Only constant memory is allowed.
 * <p/>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p/>
 * For k = 2, you should return: 2->1->4->3->5
 * <p/>
 * For k = 3, you should return: 3->2->1->4->5
 *
 * @author jack.zhang
 * @since 2015/8/22 0022
 */
public class ReverseInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode result = head;
        Stack<ListNode> nodeStack = new Stack<>();
        for (int i = 0; i < k - 1; i++) {
            nodeStack.push(result);
            result = result.next;
            if (result == null) {
                return head;
            }
        }

        ListNode next = reverseKGroup(result.next, k);
        result.next = buildReverse(nodeStack, null);
        ListNode lastNode = result;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = next;
        return result;
    }

    private ListNode buildReverse(Stack<ListNode> nodeStack, ListNode reverseNode) {
        if (nodeStack.isEmpty()) {
            if (reverseNode != null) reverseNode.next = null;
            return reverseNode;
        }
        if (reverseNode == null) {
            reverseNode = nodeStack.pop();
        }
        reverseNode.next = null;
        if (!nodeStack.isEmpty()) {
            reverseNode.next = buildReverse(nodeStack, nodeStack.pop());
        }
        return reverseNode;
    }

    public ListNode reverseKGroupV2(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
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

//        System.out.println(new ReverseInKGroup().reverseKGroup(node, 3));
//        System.out.println(new ReverseInKGroup().reverseKGroup(node, 2));
        System.out.println(new ReverseInKGroup().reverseKGroup(node, 1));
        System.out.println(new ReverseInKGroup().reverseKGroupV2(node, 1));
    }
}
