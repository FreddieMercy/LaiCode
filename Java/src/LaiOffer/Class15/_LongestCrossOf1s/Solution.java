package LaiOffer.Class15._LongestCrossOf1s;

public class Solution {
    public int largest(int[][] matrix) {
        // Write your solution here

        int[][] topToBot = new int[matrix.length][matrix[0].length];
        int[][] botToTop = new int[matrix.length][matrix[0].length];
        int[][] leftToRight = new int[matrix.length][matrix[0].length];
        int[][] rightToLeft = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (j == 0) {
                    leftToRight[i][j] = matrix[i][j];
                } else {
                    if (matrix[i][j] == 1) {
                        leftToRight[i][j] = leftToRight[i][j - 1] + 1;
                    }
                }

                if (j == 0) {
                    rightToLeft[i][matrix[0].length - 1 - j] = matrix[i][matrix[0].length - 1 - j];
                } else {
                    if (matrix[i][matrix[0].length - 1 - j] == 1) {
                        rightToLeft[i][matrix[0].length - 1 - j] = rightToLeft[i][matrix[0].length - 1 - j + 1] + 1;
                    }
                }

                if (i == 0) {
                    topToBot[i][j] = matrix[i][j];
                } else {
                    if (matrix[i][j] == 1) {
                        topToBot[i][j] = topToBot[i - 1][j] + 1;
                    }
                }

                if (i == 0) {
                    botToTop[matrix.length - 1][j] = matrix[matrix.length - 1][j];
                } else {
                    if (matrix[matrix.length - 1 - i][j] == 1) {
                        botToTop[matrix.length - 1 - i][j] = botToTop[matrix.length - 1 - i + 1][j] + 1;
                    }
                }
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
