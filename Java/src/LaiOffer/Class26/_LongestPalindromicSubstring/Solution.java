package LaiOffer.Class26._LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        // Write your solution here
        char[] zhen = s.toCharArray();
        char[] fan = s.toCharArray();

        for(int i = 0; i < s.length()/2; ++i){
            char c = fan[i];
            fan[i] = fan[s.length()-1-i];
            fan[s.length()-1-i]=c;
        }

        int[][] dp = new int[zhen.length+1][fan.length+1];
        int start = Integer.MAX_VALUE;
        int end = -1;

        for(int i = 0; i <= zhen.length;++i){
            for (int j = 0; j <= fan.length; ++j){
                dp[i][j]=-1;
                if(i == 0 || j == 0){
                    continue;
                }
                else {
                    if(zhen[i-1] == fan[j-1]) {
                        if (dp[i - 1][j - 1] == -1) {
                            dp[i][j] = i;
                        } else {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                        if(end-start< i-dp[i][j]){
                            start = dp[i][j];
                            end = i;
                        }
                    }
                }
            }
        }
        if(start<0 || end< start){
            return "";
        }
        return s.substring(start-1, end);
    }
}
