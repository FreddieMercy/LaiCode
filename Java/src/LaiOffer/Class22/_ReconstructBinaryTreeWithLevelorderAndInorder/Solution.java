package LaiOffer.Class22._ReconstructBinaryTreeWithLevelorderAndInorder;

import java.util.HashMap;
import java.util.LinkedList;
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

    public TreeNode reconstruct(int[] in, int[] level) {
        // Write your solution here

        if(in==null||level==null||in.length!=level.length||in.length==0){
            return null;
        }

        HashMap<Integer,Integer> inIndexes = new HashMap<>();

        for(int i = 0; i < in.length;++i){
            inIndexes.put(in[i], i);
        }

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(level[0]);
        int index=1;
        queue.add(root);

        while (index<level.length){
            TreeNode tmp = queue.poll();
            if(inIndexes.get(tmp.key) >0&&inIndexes.get(in[inIndexes.get(tmp.key)-1])!=null){
                tmp.left = new TreeNode(level[index]);
                queue.add(tmp.left);
                index++;
            }

            if(inIndexes.get(tmp.key) < inIndexes.size()-1&&inIndexes.get(in[inIndexes.get(tmp.key)+1])!=null){
                tmp.right = new TreeNode(level[index]);
                queue.add(tmp.right);
                index++;
            }

            inIndexes.put(tmp.key, null);
        }

        return root;
    }
}


/*
public class Solution {

    public TreeNode reconstruct(int[] in, int[] level) {
        // Write your solution here

        if(in==null||level==null||in.length!=level.length||in.length==0){
            return null;
        }

        HashMap<Integer,Integer> inIndexes = new HashMap<>();

        for(int i = 0; i < in.length;++i){
            inIndexes.put(in[i], i);
        }

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(level[0]);
        int index=1;
        queue.add(root);

        while (index<level.length){
            TreeNode tmp = queue.poll();
            if(inIndexes.get(tmp.key) >0&&inIndexes.get(in[inIndexes.get(tmp.key)-1])!=null){
                tmp.left = new TreeNode(level[index]);
                queue.add(tmp.left);
                index++;
            }

            if(inIndexes.get(tmp.key) < inIndexes.size()-1&&inIndexes.get(in[inIndexes.get(tmp.key)+1])!=null){
                tmp.right = new TreeNode(level[index]);
                queue.add(tmp.right);
                index++;
            }

            inIndexes.put(tmp.key, null);
        }

        return root;
    }
}
*/