package LaiOffer.Class15._LargestSubArraySum;

public class Solution {
    public int largestSum(int[] array) {
        // Write your solution here
        int []dp = new int[array.length];
        int ans = array[0];
        dp[0] = array[0];
        for(int i = 1; i < array.length;++i){
            if(dp[i-1] <0){
                dp[i] = array[i];
            }
            else{
                dp[i] = dp[i-1]+array[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
