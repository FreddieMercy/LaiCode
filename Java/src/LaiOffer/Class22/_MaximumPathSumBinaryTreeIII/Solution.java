package LaiOffer.Class22._MaximumPathSumBinaryTreeIII;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution {
    private int dfs(TreeNode end, int[] max) {

        if (end == null) {
            return 0;
        }

        int ans = Math.max(0, Math.max(dfs(end.left, max),dfs(end.right, max)))+end.key;
        max[0] = Math.max(max[0], ans);

        return ans;
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        dfs(root, max);
        return max[0];
    }
}

/*
public class Solution {
    private void dfs(TreeNode start, TreeNode mid, TreeNode end, int[] max) {

        if (end == null) {
            return;
        }

        max[0] = Math.max(max[0], end.key);
        if(mid!=null){
            max[0] = Math.max(max[0], mid.key+end.key);
        }

        if(start!=null){
            max[0] = Math.max(max[0], start.key+mid.key+end.key);
        }

        dfs(mid, end, end.left, max);
        dfs(mid, end, end.right, max);
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        dfs(null,null,root, max);
        return max[0];
    }
}
*/