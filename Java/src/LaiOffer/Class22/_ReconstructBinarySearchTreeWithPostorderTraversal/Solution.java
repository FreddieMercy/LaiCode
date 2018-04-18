package LaiOffer.Class22._ReconstructBinarySearchTreeWithPostorderTraversal;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution {
    private TreeNode bstInsert(TreeNode root, int i){
        if(root == null){
            return new TreeNode(i);
        }

        if(root.key < i){
            root.right = bstInsert(root.right, i);
        }
        else{
            root.left = bstInsert(root.left, i);
        }

        return root;
    }
    public TreeNode reconstruct(int[] post) {
        // Write your solution here
        if(post==null || post.length==0){
            return null;
        }
        TreeNode root = null;
        for(int i = post.length-1; i >=0; --i){
            root = bstInsert(root, post[i]);
        }
        return root;
    }
}
