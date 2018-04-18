package LaiOffer.Class22._BinaryTreePathSumToTargetIII;


import java.util.HashSet;
import java.util.Set;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution {
    private boolean exist(TreeNode root, int target, Set<Integer> sums, int sum) {

        if (root == null) {
            return false;
        }
        sum += root.key;
        if (sums.contains(sum - target)) {
            return true;
        }

        boolean needRM = sums.add(sum);

        if (exist(root.left, target, sums, sum) || exist(root.right, target, sums, sum)) {
            return true;
        }

        if(needRM){
            sums.remove(sum);
        }

        return false;
    }

    public boolean exist(TreeNode root, int target) {
        // Write your solution here

        return exist(root, target, new HashSet<Integer>() {{
            add(0);
        }}, 0);
    }
}

/*


public class Solution {
    private boolean exist(TreeNode root, int target, int sum, boolean[] ans){

        if(ans[0]){
            return ans[0];
        }

        if(root == null){
            return false;
        }

        if(root.key==target||root.key+sum == target){
            return true;
        }

        return exist(root.left, target, 0, ans) || exist(root.right, target, 0, ans) || exist(root.left, target,sum+ root.key, ans) ||exist(root.right,target,sum+root.key, ans);
    }
    public boolean exist(TreeNode root, int target) {
        // Write your solution here

        return exist(root, target, 0, new boolean[]{false});
    }
}


 */