package LaiOffer.Class18._GetKeysInBinaryTreeLayerByLayerZig_ZagOrder;


import java.util.*;

class TreeNode {
   public int key;
   public TreeNode left;
   public TreeNode right;
   public TreeNode(int key) {
     this.key = key;
   }
 }


public class Solution {
    private void offerFirst(Deque<TreeNode> dq, List<Integer> ans) {
        int size = dq.size();
        while (--size >= 0) {
            TreeNode cur = dq.pollLast();
            ans.add(cur.key);
            if (cur.right != null) {
                dq.offerFirst(cur.right);
            }
            if (cur.left != null) {
                dq.offerFirst(cur.left);
            }
        }
    }

    private void offerLast(Deque<TreeNode> dq, List<Integer> ans){
        int size = dq.size();
        while (--size>=0){
            TreeNode cur = dq.pollFirst();
            ans.add(cur.key);

            if(cur.left!=null){
                dq.offerLast(cur.left);
            }
            if(cur.right!=null){
                dq.offerLast(cur.right);
            }
        }
    }

    public List<Integer> zigZag(TreeNode root) {
        // Write your solution here
        Deque<TreeNode> dq = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        dq.offer(root);
        boolean evenOrOdd = true; //true == odd, false == even
        while (!dq.isEmpty()){
            if(evenOrOdd){
                offerFirst(dq,ans);
            }
            else{
                offerLast(dq,ans);
            }

            evenOrOdd = !evenOrOdd;
        }

        return ans;
    }
}