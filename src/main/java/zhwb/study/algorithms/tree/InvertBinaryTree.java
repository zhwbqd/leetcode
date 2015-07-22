package zhwb.study.algorithms.tree;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * <p/>
 * Invert a binary tree.
 * <p/>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * to
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 *
 * @author jack.zhang
 * @since 2015/7/20 0020
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        } else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode origin = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(7);
        right.left = new TreeNode(6);
        right.right = new TreeNode(9);
        origin.left = left;
        origin.right = right;

        TreeNode after = new InvertBinaryTree().invertTree(origin);
        System.out.println(after);
    }
}


