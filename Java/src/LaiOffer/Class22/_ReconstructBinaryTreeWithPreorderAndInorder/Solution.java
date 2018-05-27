package LaiOffer.Class22._ReconstructBinaryTreeWithPreorderAndInorder;

import java.util.HashMap;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution {
    public TreeNode reconstruct(int[] in, int[] pre) {
        // Write your solution here
        if (in == null || pre == null || in.length != pre.length || in.length==0) {
            return null;
        }

        HashMap<Integer, Integer> inIndexes = new HashMap<>();

        for(int i = 0; i < in.length; ++i){
            inIndexes.put(in[i], i);
        }

        return reconstruct(in, pre, 0, pre.length - 1, 0, in.length - 1, inIndexes);
    }

    private TreeNode reconstruct(int[] in, int[] pre, int preHead, int preTail, int inStart, int inEnd, HashMap<Integer, Integer> inIndexes) {
        if (preHead> preTail||inStart>inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preHead]);
        root.left = reconstruct(in, pre, preHead + 1, inIndexes.get(root.key)-inStart+preHead, inStart, inIndexes.get(root.key) - 1, inIndexes);
        root.right = reconstruct(in, pre, inIndexes.get(root.key)-inStart+preHead+1, preTail, inIndexes.get(root.key) + 1, inEnd, inIndexes);

        return root;
    }
}
/*
public class Solution {
    public TreeNode reconstruct(int[] in, int[] pre) {
        // Write your solution here
        if (in == null || pre == null || in.length != pre.length || in.length==0) {
            return null;
        }

        return reconstruct(in, pre, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode reconstruct(int[] in, int[] pre, int preHead, int preTail, int inStart, int inEnd) {
        if (preHead> preTail||inStart>inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preHead]);

        for (int i = 0; i <= inEnd-inStart; ++i) {
            if (in[inStart+i] == root.key) {
                root.left = reconstruct(in, pre, preHead + 1, preHead+ i, inStart, inStart+i - 1);
                root.right = reconstruct(in, pre, preHead+i+1, preTail, inStart+i + 1, inEnd);
                break;
            }
        }

        return root;
    }
}
*/