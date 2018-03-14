package LaiOffer.Class07._IsBinarySearchTreeOrNot;
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

    public boolean isBST(TreeNode root) {
        return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isBST(TreeNode root, int max, int min) {
        if (root == null) {
            return true;
        }

        if (root.key <= min || root.key >= max) {
            return false;
        }

        return isBST(root.left, root.key, min) && isBST(root.right, max, root.key);
    }
}