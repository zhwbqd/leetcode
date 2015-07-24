package zhwb.study.algorithms.linkedlist;

import java.util.Objects;

/**
 * @author jack.zhang
 * @since 2015/7/24 0024
 */
public class ListNode {
    protected int val;
    protected ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        sb.append(val);
        sb.append(",").append(next);
        sb.append(']');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode node = (ListNode) o;
        return Objects.equals(val, node.val) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
