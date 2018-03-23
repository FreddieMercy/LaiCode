package LaiOffer.Class10._LowestCommonAncestorI;


class TreeNode {
   public int key;
   public TreeNode left;
   public TreeNode right;
   public TreeNode(int key) {
     this.key = key;
   }
 }

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode one, TreeNode two) {
        if(root == null||one==root||two==root){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,one,two);
        TreeNode right = lowestCommonAncestor(root.right,one,two);

        if(left!=null&&right!=null){
            return root;
        }

        return (left!=null)?left:right;
    }
}
