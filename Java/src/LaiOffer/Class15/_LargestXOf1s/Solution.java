package LaiOffer.Class15._LargestXOf1s;

public class Solution {
    private void getTopToBot(int[][] matrix, int[][] dp, int x, int y) {
        if (x - 1 < 0 || y - 1 < 0) {
            dp[x][y]= matrix[x][y];
            return;
        }
        dp[x][y]= (matrix[x][y] != 0) ? dp[x - 1][y - 1] + matrix[x][y] : 0;
    }

    private void getBotToTop(int[][] matrix, int[][] dp, int x, int y) {
        x = matrix.length - 1 - x;
        y = matrix[0].length - 1 - y;
        if (x + 1 >= matrix.length || y + 1 >= matrix[0].length) {
            dp[x][y]= matrix[x][y];
            return;
        }
        dp[x][y]= (matrix[x][y] != 0) ? dp[x + 1][y + 1] + matrix[x][y] : 0;
    }

    private void getLeftToRight(int[][] matrix, int[][] dp, int x, int y) {
        y = matrix[0].length - 1 - y;
        if (x - 1 < 0 || y + 1 >= matrix[0].length) {
            dp[x][y]= matrix[x][y];
            return;
        }
        dp[x][y]=  (matrix[x][y] != 0) ? dp[x - 1][y + 1] + matrix[x][y] : 0;
    }

    private void getRightToLeft(int[][] matrix, int[][] dp, int x, int y) {
        x = matrix.length - 1 - x;
        if (x + 1 >= matrix.length || y - 1 < 0) {
            dp[x][y]= matrix[x][y];
            return;
        }
        dp[x][y]= (matrix[x][y] != 0) ? dp[x + 1][y - 1] + matrix[x][y] : 0;
    }

    public int largest(int[][] matrix) {
        // Write your solution here
        int[][] topToBot = new int[matrix.length][matrix[0].length];
        int[][] botToTop = new int[matrix.length][matrix[0].length];
        int[][] leftToRight = new int[matrix.length][matrix[0].length];
        int[][] rightToLeft = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {

                getTopToBot(matrix, topToBot, i, j);
                getBotToTop(matrix, botToTop, i, j);
                getLeftToRight(matrix, leftToRight, i, j);
                getRightToLeft(matrix, rightToLeft, i, j);
            }
        }

        int ans = 0;

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                ans = Math.max(ans, Math.min(Math.min(topToBot[i][j], botToTop[i][j]), Math.min(leftToRight[i][j], rightToLeft[i][j])));
            }
        }

        return ans;

    }
}