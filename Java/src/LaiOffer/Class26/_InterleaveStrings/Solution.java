package LaiOffer.Class26._InterleaveStrings;

public class Solution {
    public boolean canMerge(String a, String b, String c) {
        // Write your solution here
        if(a.length()+b.length()!=c.length()){
            return false;
        }
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        char[] C = c.toCharArray();
        boolean[][] dp = new boolean[A.length + 1][B.length + 1];
        for (int i = 0; i <= A.length; ++i) {
            for (int j = 0; j <= B.length; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] |= ((i>0&&dp[i - 1][j] && (A[i - 1] == C[i + j - 1])) || (j>0&&dp[i][j - 1] && (B[j - 1] == C[i + j - 1])));
                }
            }
        }
        return dp[A.length][B.length];
    }
}