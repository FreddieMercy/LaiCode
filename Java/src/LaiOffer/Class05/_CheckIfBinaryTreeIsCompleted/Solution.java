package LaiOffer.Class05._CheckIfBinaryTreeIsCompleted;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
        this.key = key;
    }
}


public class Solution {

    public boolean isCompleted(TreeNode root) {
        Queue<TreeNode> dfs = new LinkedList<>();
        boolean flag = false;
        if (root == null) {
            return true;
        }
        dfs.add(root);

        while (!dfs.isEmpty()) {
            root = dfs.poll();

            if ((root.left == null && root.right != null) || (flag && (root.left != null || root.right != null))) {
                return false;
            }

            if (root.left != null && root.right == null) {

                flag = true;

                dfs.add(root.left);
            } else if (root.left != null && root.right != null) {
                dfs.add(root.left);
                dfs.add(root.right);
            } else {
                flag = true;
            }
        }

        return true;
    }
}