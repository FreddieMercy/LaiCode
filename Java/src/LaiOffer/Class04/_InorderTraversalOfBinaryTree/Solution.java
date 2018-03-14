/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
 */
package LaiOffer.Class04._InorderTraversalOfBinaryTree;
import java.util.List;
import java.util.ArrayList;
/**
 *
@author junhaozhang
 */

class TreeNode {
  public int key;
  public TreeNode left;
  public TreeNode right;
  public TreeNode(int key) {
    this.key = key;
  }
}

public class Solution {
    public List<Integer> inOrder(TreeNode root) {
        // Write your solution here
        List<Integer> ans = new ArrayList<>();
        inOrderAdding(root, ans);

        return ans;

    }

    private void inOrderAdding(TreeNode root, List<Integer> list){
        if(root==null || list == null){
            return;
        }
        inOrderAdding(root.left, list);
        list.add(root.key);
        inOrderAdding(root.right, list);
    }
}
