/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.July2017.July31st2017._104MaximumDepthOfBinaryTree;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhao.zhang.freddie
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = 1, right = 1;
        if(root.left!=null)
        {
            left += this.maxDepth(root.left);
        }
        if (root.right!=null){
            right += this.maxDepth(root.right);
        }
        
        return Math.max(left,right);
    }
}       