package LaiOffer.Class12._MaxProductOfCuttingRope;

public class Solution {
    private int getMax(int length, int[] dp, boolean[] visited) {
        if (visited[length]) {
            return dp[length];
        }

        for (int i = 1; i <= length / 2; ++i) {
            dp[length] = Math.max(Math.max(dp[length],length), getMax(i, dp, visited) * getMax(length - i, dp, visited));
        }

        visited[length] = true;

        return dp[length];
    }

    public int maxProduct(int length) {
        // Write your solution here
        if (length <= 3) {
            return length-1;
        }
        int[] dp = new int[length + 1];
        boolean[] visited = new boolean[length + 1];
        visited[0] = true;
        visited[1] = true;
        dp[1] = 1;

        return getMax(length, dp, visited);

    }
}