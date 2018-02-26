/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.July2017.July31st2017._101SymmetricTree;
import java.util.*;
/**
 *
 * @author junhao.zhang.freddie
 */

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private boolean Summe(TreeNode left, TreeNode right){
        if(left==null && right == null)
        {
            return true;
        }
        if(left==null || right == null){
            return false;
        }
        if(left.val == right.val)
        {
            return this.Summe(left.left, right.right) && this.Summe(left.right, right.left);
        }
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        return this.Summe(root, root);
    }
}