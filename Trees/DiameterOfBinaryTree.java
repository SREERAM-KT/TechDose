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
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        height(root);
        return ans;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        int l = height(root.left);
        int r = height(root.right);
        ans = Math.max(ans, l + r);
        return 1 + Math.max(l, r);
    }
}