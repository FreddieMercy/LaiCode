package LaiOffer.Class04._SymmetricBinaryTree;
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
    private boolean comp(TreeNode left, TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if((left != null && right == null) || (left == null && right != null) || (left!=null&&right!=null && left.key != right.key)){
            return false;
        }
        return comp(left.left, right.right) && comp(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        // Write your solution here
        if(root == null){
            return true;
        }
        return comp(root.left, root.right);
    }
}
