package LaiOffer.Class15._LargestSubMatrixSum;

public class Solution {
    private int Max(int[] array) {
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

    public int largest(int[][] matrix) {
        // Write your solution here

        int ans =Integer.MIN_VALUE;
        for(int row = 0; row<matrix.length;row++){
            int[] total = new int[matrix[0].length];

            for(int cur = row; cur < matrix.length;cur++){
                for(int i = 0; i < matrix[cur].length; ++i){
                    total[i]+=matrix[cur][i];
                }
                ans = Math.max(ans, Max(total));
            }
        }

        return ans;
    }
}
