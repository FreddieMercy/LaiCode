package LaiOffer.Class27._LongestAscendingSubsequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int longest(int[] array) {
        // Write your solution here
        int[] dp = new int[array.length+1];
        int result = 0;
        for(int i = 0; i < array.length; ++i){
            if(i==0){
                dp[++result] = array[i];
            }
            else {
                int index = find(dp,1, result, array[i]);
                if(result==index){
                    dp[++result] = array[i];
                }
                else {
                    dp[index+1] = array[i];
                }
            }
        }

        return result;
    }

    private int find(int[] array, int left,int right, int target){
        while (left<=right){
            int mid = (right-left)/2+left;
            if(array[mid]>=target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return right;
    }
}
