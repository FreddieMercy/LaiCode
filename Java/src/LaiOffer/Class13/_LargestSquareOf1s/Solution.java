package LaiOffer.Class13._LargestSquareOf1s;

public class Solution {
    public int largest(int[][] matrix) {
        // Write your solution here
        int [][] dp = new int[matrix.length+1][matrix[0].length+1];
        int ans = 0;
        for(int i = 0; i < matrix.length;++i){
            for(int j =0; j<matrix[0].length;++j){
                if(matrix[i][j]==1){
                    dp[i+1][j+1] = Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1]))+1;
                    ans = Math.max(ans, dp[i+1][j+1]);
                }
            }
        }

        return ans;
    }
}
