package LaiOffer.Class21._SearchInBinarySearchTree;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution {
    public TreeNode search(TreeNode root, int key) {
        // Write your solution here
        if (root == null||root.key == key) {
            return root;
        }
        if (key > root.key) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }
    }
}
