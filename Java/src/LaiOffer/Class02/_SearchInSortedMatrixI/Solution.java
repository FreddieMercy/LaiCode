/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaiOffer.Class02._SearchInSortedMatrixI;

/**
 *
 * @author junhaozhang
 */
public class Solution {

    private int binarySearch(int[][] matrix, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (matrix[mid / matrix[0].length][mid % matrix[0].length] == target) {
            return mid;
        }

        if (matrix[mid / matrix[0].length][mid % matrix[0].length] > target) {

            return binarySearch(matrix, target, left, mid - 1);
        }

        return binarySearch(matrix, target, mid + 1, right);
    }

    public int[] search(int[][] matrix, int target) {
        // Write your solution here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }

        int ans = binarySearch(matrix, target, 0, matrix.length * matrix[0].length-1);
        if(ans==-1){
            return new int[]{-1, -1};
        }
        return new int[]{ans / matrix[0].length, ans % matrix[0].length};
    }
}
