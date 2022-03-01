
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int max = Integer.MIN_VALUE;

    public int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        max = Math.max(max, Math.max(root.val + left + right, Math.max(root.val, root.val + Math.max(left, right))));
        return Math.max(root.val + Math.max(left, right), root.val);
    }

    public int maxPathSum(TreeNode root) {
        int val = postOrder(root);
        return Math.max(val, max);
    }
}