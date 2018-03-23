package LaiOffer.Class10._SpiralOrderTraverseII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        top(0, 0, matrix.length, matrix[0].length, matrix, ans);
        return ans;
    }

    private void top(int startX, int startY, int height, int width, int[][] array, List<Integer> ans) {

        int length = width;
        if (array == null || length < 0) {
            return;
        }
        length--;

        if (length == 0 && height == 0) {
            ans.add(array[startY][startX]);
            return;
        }

        for (int i = 0; i < length; ++i) {
            ans.add(array[startY][startX + i]);
        }

        right(startX + length, startY, height, length, array, ans);
    }

    private void right(int startX, int startY, int height, int width, int[][] array, List<Integer> ans) {

        int length = height;

        if (array == null || length < 0) {
            return;
        }

        length--;

        if (length == 0 && width == 0) {
            ans.add(array[startY][startX]);
            return;
        }


        for (int i = 0; i < length; ++i) {
            ans.add(array[startY + i][startX]);
        }


        bot(startX, startY + length, length, width, array, ans);
    }

    private void bot(int startX, int startY, int height, int width, int[][] array, List<Integer> ans) {

        int length = width;
        if (array == null || length < 0) {
            return;
        }

        if (length == 0 && height == 0) {
            ans.add(array[startY][startX]);
            return;
        }


        for (int i = 0; i < length; ++i) {
            ans.add(array[startY][startX - i]);
        }

        left(startX - length, startY, height, length, array, ans);
    }

    private void left(int startX, int startY, int height, int width, int[][] array, List<Integer> ans) {

        int length = height;
        if (array == null || length < 0) {
            return;
        }

        if (length == 0 && width == 0) {
            ans.add(array[startY][startX]);
            return;
        }

        for (int i = 0; i < length; ++i) {
            ans.add(array[startY - i][startX]);

        }
        length--;

        top(startX + 1, startY - length, length, width, array, ans);
    }
}