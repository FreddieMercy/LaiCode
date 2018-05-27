package LaiOffer.Class18._RotateMatrix;


public class Solution {
    public void rotate(int[][] matrix) {
        // Write your solution here.
        int left = 0;
        int right = matrix.length-1;

        while (left<right) {
            for (int i = left; i < right; ++i) {
                swap(matrix, left, i, i, right);
                swap(matrix, left, i, right, right+left-i);
                swap(matrix, left, i, right+left-i, left);
            }
            left++;
            right--;
        }
    }
    private void swap(int[][] matrix, int x, int y, int r, int c){
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[r][c];
        matrix[r][c] = tmp;
    }
}

/*
public class Solution {
    private void rotate(int step, int length, int[][] matrix, int[] buffer) {

        if (matrix == null || length <= 0) {
            return;
        }
        for (int i = 0; i < length; ++i) {
            buffer[i] = matrix[step][step+i];
        }

        for (int i = 0; i < length; ++i) {
            int tmp = buffer[i];
            buffer[i] = matrix[step + i][length + step];
            matrix[step + i][length + step] = tmp;
        }
        for (int i = 0; i < length; ++i) {
            int tmp = buffer[i];
            buffer[i] = matrix[length + step][length + step - i];
            matrix[length + step][length + step - i] = tmp;
        }
        for (int i = 0; i < length; ++i) {
            int tmp = buffer[i];
            buffer[i] = matrix[length - i + step][step];
            matrix[length - i + step][step] = tmp;
        }

        for (int i = 0; i < length; ++i) {
            matrix[step][i + step]=buffer[i];
        }

        rotate(step+1, length-2, matrix, buffer);
    }

    public void rotate(int[][] matrix) {
        // Write your solution here.
        int length = matrix.length-1;
        if(length<=0){
            return;
        }
        int[] buffer = new int[length];

        rotate(0, length, matrix, buffer);

    }
}
*/