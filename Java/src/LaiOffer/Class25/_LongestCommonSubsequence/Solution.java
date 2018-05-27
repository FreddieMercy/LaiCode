package LaiOffer.Class25._LongestCommonSubsequence;

public class Solution {
    public int longest(String s, String t) {
        // Write your solution here
        if(s==null||t==null){
            return 0;
        }

        int lenS = s.length();
        int lenT = t.length();

        int[][] dp = new int[lenS+1][lenT+1];

        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        for(int i  = 0; i <= lenS; ++i){
            for(int j = 0; j <= lenT; ++j){
                if(i==0||j==0) {
                    continue;
                }
                if(S[i - 1] == T[j - 1]){
                    dp[i][j] = Math.max(Math.max(dp[i-1][j-1]+1, dp[i-1][j]), dp[i][j-1]);
                }
                else{
                    dp[i][j] = Math.max(Math.max(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                }
            }
        }
        return dp[lenS][lenT];
    }
}
