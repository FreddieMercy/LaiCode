package LaiOffer.Class22._MaximumPathSumBinaryTreeII;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution {
    private int dfs(TreeNode root, int[] max, int sum) {

        if (root == null) {
            return 0;
        }

        int s = root.key;
        if (sum > 0) {
            s += sum;
        }

        max[0] = Math.max(max[0], s);

        // please follow the solution covered in class to re-do this problem
        int left = dfs(root.left, max, s);
        int right = dfs(root.right, max, s);

        max[0] = Math.max(max[0], left + right + root.key);
        return Math.max(root.key, Math.max(left + root.key, right + root.key));
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        dfs(root, max, 0);
        return max[0];
    }
}
