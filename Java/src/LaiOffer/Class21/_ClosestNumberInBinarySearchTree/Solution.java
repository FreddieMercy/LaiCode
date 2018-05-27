package LaiOffer.Class21._ClosestNumberInBinarySearchTree;


import com.sun.javafx.collections.MappingChange;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}
public class Solution {
    public int closest(TreeNode root, int target) {
        // Write your solution here
        return closest(root, target, Integer.MAX_VALUE);
    }

    private int closest(TreeNode root, int target, int ans) {

        if (root == null) {
            return ans;
        }

        if (root.key == target) {
            return root.key;
        }

        if (root.key < target) {
            return closest(root.right, target, (Math.abs(root.key - target) > Math.abs(ans - target)) ? ans : root.key);

        }
        return closest(root.left, target, (Math.abs(root.key - target) > Math.abs(ans - target)) ? ans : root.key);
    }
}