package LaiOffer.Class18._LowestCommonAncestorIV;


import java.util.HashSet;
import java.util.List;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution {
    private TreeNode LCAk(TreeNode root, List<TreeNode> nodes) {
        // Write your solution here.
        if(root==null||nodes==null||nodes.isEmpty()){
            return null;
        }

        TreeNode left = LCAk(root.left, nodes);
        TreeNode right = LCAk(root.right, nodes);

        if(nodes.contains(root)){
            //nodes.remove(root);
            return root;
        }

        if(left!=null&&right!=null){
            return root;
        }

        return (left!=null)?left:right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        List<TreeNode> node = nodes;
        root = LCAk(root, node);
/*
        if(!node.isEmpty()){
            return null;
        }
*/
        return root;
    }
}