package zhwb.study.algorithms.tree;

/**
 * https://leetcode.com/problems/same-tree/
 * <p/>
 * Given two binary trees, write a function to check if they are equal or not.
 * <p/>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * @author jack.zhang
 * @since 2015/7/22 0022
 */
public class BinaryTreeSame {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val != q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeSame().isSameTree(new TreeNode(1), new TreeNode(2)));//false
        System.out.println(new BinaryTreeSame().isSameTree(new TreeNode(1), new TreeNode(1)));//true

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(3);
        System.out.println(new BinaryTreeSame().isSameTree(p, q)); //false

        System.out.println(new BinaryTreeSame().isSameTree(null, new TreeNode(1)));//false
        System.out.println(new BinaryTreeSame().isSameTree(null, null));//true
    }
}

