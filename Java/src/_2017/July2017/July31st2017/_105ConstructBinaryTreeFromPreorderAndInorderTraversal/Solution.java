/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.July2017.July31st2017._105ConstructBinaryTreeFromPreorderAndInorderTraversal;
import java.lang.*;
import java.util.*;
/**uly017.
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
    private Map<Integer,Integer> _inorder = new HashMap<Integer,Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length != inorder.length||preorder.length==0)
        {
            return null;
        }
        for(int i = 0; i < inorder.length;++i)
        {
            _inorder.put(inorder[i], i);
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> parent = new Stack<TreeNode>();
        TreeNode tmp = root;
        
        for(int i = 1; i < preorder.length;++i)
        {
            if(_inorder.get(preorder[i-1]) > _inorder.get(preorder[i])){
                root.left = new TreeNode(preorder[i]);
                parent.add(root);
                root = root.left;
            }
            else{
                if(!parent.empty())
                {
                    TreeNode t = parent.pop();
                    TreeNode pre = null;
                    while(!parent.empty() && _inorder.get(t.val)<=_inorder.get(preorder[i]))
                    {
                        pre = t;
                        t = parent.pop();
                    }
 
                    if(pre!=null && _inorder.get(t.val)>_inorder.get(preorder[i]))
                    {
                        root = pre;
                        parent.add(t);
                    }
                    else if(_inorder.get(t.val)<=_inorder.get(preorder[i])){
                        root = t;
                    }
                    else{
                        parent.add(t);
                    }
                }
                root.right = new TreeNode(preorder[i]);
                root = root.right;
                
            }
        }
        
        return tmp;
    }
}