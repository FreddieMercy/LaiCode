package LaiOffer.Class21._DeleteInBinarySearchTree;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution {
    /*
    private TreeNode getMostLeft(TreeNode root) {
        while (root.right.right != null) {
            root = root.right;
        }
        TreeNode whatWeWant = root.right;
        root.right = delete(root.right, root.right.key);
        return whatWeWant;
    }
*/
    private TreeNode getRightMost(TreeNode root) {
        if (root.right.left == null) {
            TreeNode whatWeWant = root.right;
            root.right = whatWeWant.right;
            return whatWeWant;
        }
        root = root.right;
        while (root.left.left != null) {
            root = root.left;
        }
        TreeNode whatWeWant = root.left;
        root.left = whatWeWant.right;
        return whatWeWant;
    }

    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.key == key) {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left != null && root.right != null) {
                TreeNode newRoot = getRightMost(root);
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }

            return (root.left == null) ? root.right : root.left;

        } else if (key > root.key) {
            root.right = delete(root.right, key);

        } else {
            root.left = delete(root.left, key);
        }

        return root;
    }
}