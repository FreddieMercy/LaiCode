package LaiOffer.Class10._SpiralOrderGenerateII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] spiralGenerate(int m, int n) {
        // Write your solution here.
        int[][] ans = new int[m][n];

        int start = 0;
        int end = n - 1;
        int top = 0;
        int bot = m - 1;
        int index=1;

        while (start < end && top < bot) {
            for (int i = start; i < end; ++i) {
                ans[start][i]=index;
                index++;
            }
            for (int i = top; i < bot; ++i) {
                ans[i][end] = index;
                index++;
            }
            for (int i = end; i > start; --i) {
                ans[bot][i]=index;
                index++;
            }
            for (int i = bot; i > top; --i) {
                ans[i][start]=index;
                index++;
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
                ans[i][end] = index;
                index++;
            }
        } else {
            for (int i = start; i <= end; ++i) {
                ans[start][i]=index;
                index++;
            }
        }

        return ans;
    }
}
