package LaiOffer.Class25._LongestCommonSubstring;

public class Solution {
    public String longestCommon(String s, String t) {
        // Write your solution here
        if(s==null||t==null){
            return "";
        }

        int lenS = s.length();
        int lenT = t.length();

        int start =Integer.MAX_VALUE;
        int end=-1;

        int[][] dp = new int[lenS+1][lenT+1];

        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        for(int i  = 0; i <= lenS; ++i){
            for(int j = 0; j <= lenT; ++j){
                dp[i][j] = -1;
                if(i>=1&&j>=1&&(S[i - 1] == T[j - 1])){
                    if(dp[i-1][j-1]==-1){
                        dp[i][j] = i;
                    }
                    else {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    if(i-dp[i][j] > end-start){
                        start=dp[i][j];
                        end = i;
                    }
                }
            }
        }

        if(start<1||end<start){
            return "";
        }
        StringBuilder ans = new StringBuilder();

        for(int i = start-1; i <=end-1; ++i){
            ans.append(S[i]);
        }

        return ans.toString();
    }
}
