package LaiOffer.Class24._ReverseBinaryTreeUpsideDown;

import java.util.ArrayList;
import java.util.List;


class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution {
    public TreeNode reverse(TreeNode root) {
        // Write your solution here
        if(root == null){
            return root;
        }
        TreeNode[] ans = new TreeNode[1];
        reverse(root, ans);
        root.left = null;
        root.right=null;
        return ans[0];
    }

    public TreeNode reverse(TreeNode root, TreeNode[] ans) {
        // Write your solution here

        if (root == null || (root.left == null && root.right == null)) {
            ans[0] = root;
        } else {
            TreeNode newRoot = reverse(root.left, ans);
            newRoot.left = root;
            newRoot.right = root.right;
        }
        return root;
    }
}