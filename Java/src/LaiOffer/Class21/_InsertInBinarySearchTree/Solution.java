package LaiOffer.Class21._InsertInBinarySearchTree;


class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution {
    public TreeNode insert(TreeNode root, int key) {
        // Write your solution here
        if (root == null) {
            return new TreeNode(key);
        }
        if (root.key == key) {
            return root;
        }
        if (key > root.key) {
            root.right = insert(root.right, key);
            return root;
        } else {
            root.left = insert(root.left, key);
            return root;
        }
    }
}