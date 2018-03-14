package LaiOffer.Class04._TweakedIdenticalBinaryTrees;
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
        return (comp(left.left, right.left) && comp(left.right, right.right)) || (comp(left.left, right.right) && comp(left.right, right.left));
    }
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        // Write your solution here
        return comp(one,two);
    }
}
