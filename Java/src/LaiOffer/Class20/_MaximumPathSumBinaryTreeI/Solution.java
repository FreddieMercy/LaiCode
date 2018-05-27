package LaiOffer.Class20._MaximumPathSumBinaryTreeI;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}
class Solution{

    private int dfs(TreeNode root, int[] max){

        if(root == null){
            return 0;
        }
        // please follow the solution covered in class to re-do this problem
        int left = dfs(root.left, max);
        int right = dfs(root.right, max);
        if(root.left!=null && root.right!=null) {
            max[0] = Math.max(max[0], left + right + root.key);
            return Math.max(left + root.key, right + root.key);
        }

        return (root.left!=null)?left + root.key:right+root.key;
    }

    public int maxPathSum(TreeNode root){
        int[] max = new int[]{Integer.MIN_VALUE};
        dfs(root, max);
        return max[0];
    }
}

/*
class Solution{

    private int dfs(TreeNode root, int[] max){

        if(root == null){
            return 0;
        }
        // please follow the solution covered in class to re-do this problem
        int left = dfs(root.left, max);
        int right = dfs(root.right, max);
        max[0] = Math.max(max[0], left+right+root.key);
        return Math.max(left+root.key,right+root.key);
    }

    public int maxPathSum(TreeNode root){
        int[] max = new int[]{Integer.MIN_VALUE};
        dfs(root, max);
        return max[0];
    }
}
*/