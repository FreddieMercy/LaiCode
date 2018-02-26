package LaiOffer.Class4._postorderTraversalOfBinaryTree;
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
    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here
        List<Integer> ans = new ArrayList<>();
        postOrderAdding(root, ans);
        return ans;

    }

    private void postOrderAdding(TreeNode root, List<Integer> list){
        if(root==null || list == null){
            return;
        }
        postOrderAdding(root.left, list);
        postOrderAdding(root.right, list);
        list.add(root.key);
    }
}
