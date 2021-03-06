package LaiOffer.Class10._SpiralOrderTraverseII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int start = 0;
        int end = matrix[0].length - 1;
        int top = 0;
        int bot = matrix.length - 1;

        while (start < end && top < bot) {
            for (int i = start; i < end; ++i) {
                ans.add(matrix[start][i]);
            }
            for (int i = top; i < bot; ++i) {
                ans.add(matrix[i][end]);
            }
            for (int i = end; i > start; --i) {
                ans.add(matrix[bot][i]);
            }
            for (int i = bot; i > top; --i) {
                ans.add(matrix[i][start]);
            }

            start++;
            end--;
            top++;
            bot--;
        }

        if (start > end || top > bot) {
            return ans;
        }

        if (start == end) {
            for (int i = top; i <= bot; ++i) {
                ans.add(matrix[i][end]);
            }
        } else {
            for (int i = start; i <= end; ++i) {
                ans.add(matrix[start][i]);
            }
        }


        return ans;
    }
}