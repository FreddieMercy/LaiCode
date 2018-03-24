package LaiOffer.Practise._Quiz_LargestSubArraySum;

public class Solution {
    public int[] largestSum(int[] array) {

        // Write your solution here
        int []dp = new int[array.length];
        int ans = array[0];
        int left = 0;
        int right = 0;
        int tmpLeft = 0;
        int tmpRight = 0;
        dp[0] = array[0];
        for(int i = 1; i < array.length;++i){
            if(dp[i-1] <0){
                dp[i] = array[i];

                tmpLeft = i;
                tmpRight = i;

            }
            else{
                dp[i] = dp[i-1]+array[i];
                if(dp[i]>dp[i-1]){
                    tmpRight = i;
                }
            }

            if(ans < dp[i]){
                ans = dp[i];
                left = tmpLeft;
                right = tmpRight;
            }
        }
        return new int[]{ans, left, right};
    }
}
