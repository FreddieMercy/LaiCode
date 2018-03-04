package LaiOffer.Class4._CheckIfBinaryTreeIsBalanced;
import java.util.List;
import java.util.ArrayList;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution {
    private boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        // Write your solution here
        getDepthOfBranches(root);
        boolean retV = ans;
        ans = true;
        return retV;
    }

    private int getDepthOfBranches(TreeNode root){
        if(root == null||!ans){
            return 0;
        }
        int left =getDepthOfBranches(root.left);
        int right = getDepthOfBranches(root.right);
        if(Math.abs(left-right)>1){
            ans = false;
        }

        return Math.max(left,right)+1;
    }
}
