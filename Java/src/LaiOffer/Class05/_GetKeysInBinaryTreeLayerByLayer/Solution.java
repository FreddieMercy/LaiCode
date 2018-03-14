package LaiOffer.Class05._GetKeysInBinaryTreeLayerByLayer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
        this.key = key;
    }
}


public class Solution {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        // Write your solution here
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        int size = 0;

        if (root == null) {
            return ans;
        }

        queue.add(root);
        size = queue.size();

        while (!queue.isEmpty()) {
            root = queue.poll();
            layer.add(root.key);

            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }

            size--;
            if (size == 0) {
                ans.add(layer);
                size = queue.size();
                layer = new ArrayList<>();
            }
        }

        return ans;
    }
}