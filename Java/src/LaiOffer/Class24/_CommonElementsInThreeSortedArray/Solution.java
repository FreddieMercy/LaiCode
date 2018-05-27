package LaiOffer.Class24._CommonElementsInThreeSortedArray;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution {
    public List<Integer> common(int[] a, int[] b, int[] c) {
        // Write your solution here
        int[] I = (a==null)?new int[0] : a;
        int[] J = (a==null)?new int[0] : b;
        int[] K = (a==null)?new int[0] : c;

        int i = 0;
        int j = 0;
        int k = 0;
        List<Integer> ans = new ArrayList<Integer>();

        while(i<I.length && j < J.length && k < K.length){
            if(I[i] == J[j] && J[j] == K[k]){
                ans.add(I[i]);
                i++;
                j++;
                k++;
            }
            else{
                int min = Math.min(I[i], Math.min(J[j], K[k]));
                if(min == I[i]){
                    i++;
                    continue;
                }

                if(min == J[j]){
                    j++;
                    continue;
                }

                k++;
                continue;
            }

        }

        return ans;
    }

}
