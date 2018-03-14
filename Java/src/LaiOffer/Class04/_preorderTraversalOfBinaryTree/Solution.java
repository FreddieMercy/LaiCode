package LaiOffer.Class04._preorderTraversalOfBinaryTree;
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
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrderAdding(root, ans);

        return ans;

    }

    private void preOrderAdding(TreeNode root, List<Integer> list){
        if(root==null || list == null){
            return;
        }
        list.add(root.key);
        preOrderAdding(root.left, list);
        preOrderAdding(root.right, list);
    }
}