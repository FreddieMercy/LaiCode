package LaiOffer.Class04._postorderTraversalOfBinaryTree;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;

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

        if(root==null){
            return ans;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode pre = new TreeNode(0);

        while(!stack.isEmpty()) {

            if (stack.peek().left != null && stack.peek().left != pre && stack.peek().right != pre) {
                stack.push(stack.peek().left);
                continue;
            }

            if (stack.peek().right != null && stack.peek().right != pre) {
                stack.push(stack.peek().right);
                continue;
            }
            pre = stack.poll();
            ans.add(pre.key);
        }

        return ans;

    }
}



/*
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
*/
