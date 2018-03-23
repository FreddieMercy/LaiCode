package LaiOffer.Class13._EditDistance;

public class Solution {
    public int editDistance(String one, String two) {
        // Write your solution here
        if (one == null || one.length() == 0 || two == null || two.length() == 0) {
            return Math.max(((one == null) ? 0 : one.length()), ((two == null) ? 0 : two.length()));
        }
        int[][] dp = new int[one.length() + 1][two.length() + 1];

        for (int i = 0; i <= one.length(); ++i) {
            for (int j = 0; j <= two.length(); ++j) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (one.toCharArray()[i - 1] != two.toCharArray()[j - 1]) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[one.length()][two.length()];
    }
}