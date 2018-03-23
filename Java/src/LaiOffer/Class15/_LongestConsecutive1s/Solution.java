package LaiOffer.Class15._LongestConsecutive1s;

public class Solution {
    public int longest(int[] array) {
        // Write your solution here
        if(array == null|| array.length==0){
            return 0;
        }

        int[] dp = new int[array.length];
        int ans = array[0];
        dp[0] = array[0];
        for(int i =1;i< array.length;++i){
            if(array[i] == 1){
                dp[i] = dp[i-1]+1;
            }
            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }
}
