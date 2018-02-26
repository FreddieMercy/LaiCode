/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.July2017.July30th2017._108ConvertSortedArrayToBinarySearchTree;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(nums[nums.length/2]);
        root.left = ((nums.length/2>=0)?this.sortedArrayToBST((int[])Arrays.copyOfRange(nums, 0, nums.length/2)):null);
        root.right = ((nums.length/2+1>=0 && nums.length>=0 && nums.length/2+1 < nums.length)?this.sortedArrayToBST((int[])Arrays.copyOfRange(nums, nums.length/2+1, nums.length)):null);
        return root;
    }
}