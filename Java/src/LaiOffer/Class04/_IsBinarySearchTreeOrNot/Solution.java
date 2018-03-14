package LaiOffer.Class04._IsBinarySearchTreeOrNot;
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

/*
public class Solution {
    private boolean isBSTWithLimit(TreeNode root, int Limit, int Parent, boolean isLeft, boolean isTwist){
        return root==null || (((isLeft^isTwist)?(root.key < Limit):(root.key>Limit)) && (root.left == null||root.left.key<root.key) && (root.right == null || root.right.key> root.key)
                && isBSTWithLimit(root.left, ((!isLeft)?Parent:root.key),root.key, true, !isLeft)
                && isBSTWithLimit(root.right, ((isLeft)?Parent:root.key),root.key, false, isLeft));
    }

    public boolean isBST(TreeNode root) {
        // Write your solution here
        return isBSTWithLimit(root, Integer.MAX_VALUE,Integer.MAX_VALUE, true, false);
    }
}
*/