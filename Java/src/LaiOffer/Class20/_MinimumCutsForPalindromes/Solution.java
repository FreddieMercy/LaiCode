package LaiOffer.Class20._MinimumCutsForPalindromes;


public class Solution {

    public int minCuts(String input) {

        if (input == null || input.length() <= 1) {
            return 0;
        }
        char[] s = input.toCharArray();  // why do you need to convert to StringBuilder?
        int[] dp = new int[input.length() + 1];
        boolean[][] isP = new boolean[input.length() + 1][input.length() + 1];
        for (int target = 1; target < dp.length; ++target) {
            dp[target] = target;
            for (int cur = target; cur >= 1; --cur) {
                //check is palindrone
                isP[cur][target] = (target == cur) || ((s[cur - 1] == s[target - 1]) && (target == cur + 1 || isP[cur + 1][target - 1]));
                if (isP[cur][target]) { // taking substring is not efficient
                    dp[target] = Math.min(dp[target], 1 + dp[cur - 1]);
                }
            }
        }

        return dp[input.length()] - 1;

    }
}

/*


public class Solution {
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.toCharArray()[i] != s.toCharArray()[s.length() - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public int minCuts(String input) {

        if (input == null || input.length() <= 1) {
            return 0;
        }
        StringBuilder s = new StringBuilder(input);  // why do you need to convert to StringBuilder?
        int[] dp = new int[input.length() + 1];
        for (int i = 1; i < dp.length; ++i) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int target = 1; target < dp.length; ++target) {
            for (int cur = 0; cur < target; ++cur) {
                if (isPalindrome(s.substring(cur, target))) { // taking substring is not efficient
                    dp[target] = Math.min(dp[target], 1 + dp[cur]);
                }
            }
        }

        return dp[input.length()] - 1;

    }
}

 */