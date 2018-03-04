package LaiOffer.Class4._GetKeysInBinarySearchTreeInGivenRange;
import java.util.List;
import java.util.ArrayList;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution {
    private void collectByNodes(TreeNode root, int min, int max, List<Integer> ans){
        if(root == null){
            return;
        }

        if(root.key > min){
            collectByNodes(root.left, min, max, ans);
        }

        if(root.key >= min && root.key <= max){
            ans.add(root.key);
        }

        if(root.key < max){
            collectByNodes(root.right, min, max, ans);
        }
    }

    public List<Integer> getRange(TreeNode root, int min, int max) {
        // Write your solution here
        List<Integer> ans = new ArrayList<>();
        collectByNodes(root, min, max, ans);
        //Integer[] array = ans.toArray(new Integer[0]);
        //Arrays.sort(array);
        //return Arrays.asList(array);
        return ans;
    }
}
