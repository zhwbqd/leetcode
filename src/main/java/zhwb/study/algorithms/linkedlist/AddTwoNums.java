package zhwb.study.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * <p/>
 * <p/>
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p/>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * @author jack.zhang
 * @since 2015/7/24 0024
 */
public class AddTwoNums {
    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int x = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
        if (x >= 10) {
            int i = x / 10;
            if (l1 != null) {
                l1.next = new ListNode(l1.next == null ? i : l1.next.val + i);
            } else {
                l2.next = new ListNode(l2.next == null ? i : l2.next.val + i);
            }
            x = x % 10;
        }
        ListNode node = new ListNode(x);
        node.next = addTwoNumbersV2(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        return node;
        //why it cannot pass?
    }

    private int carry;

    public ListNode addTwoNumbersV3(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            if (carry == 0) {
                return null;
            }
            return new ListNode(1);
        }
        int x = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        carry = x / 10;
        x = x % 10;
        ListNode node = new ListNode(x);
        node.next = addTwoNumbersV3(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        return node;
        //增加carry, 解决V2问题
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        List<Integer> l1c = new ArrayList<>();
        List<Integer> l2c = new ArrayList<>();
        addIntoList(l1c, l1);
        addIntoList(l2c, l2);

        StringBuilder sb = new StringBuilder(l1c.size());
        for (int i = l1c.size() - 1; i >= 0; i--) {
            sb.append(l1c.get(i));
        }

        StringBuilder sb1 = new StringBuilder(l2c.size());
        for (int i = l2c.size() - 1; i >= 0; i--) {
            sb1.append(l2c.get(i));
        }

        long result = Long.valueOf(sb.toString()) + Long.valueOf(sb1.toString());

        char[] chars = new StringBuilder(String.valueOf(result)).reverse().toString().toCharArray();

        ListNode root = new ListNode(Integer.valueOf(String.valueOf(chars[0])));
        ListNode node = root;
        for (int i = 1; i < chars.length; i++) {
            node.next = new ListNode(Integer.valueOf(String.valueOf(chars[i])));
            node = node.next;
        }
        return root;
    }


    void addIntoList(List<Integer> list, ListNode node) {
        if (node != null) {
            list.add(node.val);
            addIntoList(list, node.next);
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        System.out.println(new AddTwoNums().addTwoNumbers(l1, l2));
        System.out.println(new AddTwoNums().addTwoNumbersV3(l1, l2));
        System.out.println(new AddTwoNums().addTwoNumbersV2(l1, l2));


        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(new AddTwoNums().addTwoNumbers(l1, l2));
        System.out.println(new AddTwoNums().addTwoNumbersV2(l1, l2));
    }
}
