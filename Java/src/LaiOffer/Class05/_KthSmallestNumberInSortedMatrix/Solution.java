/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaiOffer.Class5._KthSmallestNumberInSortedMatrix;
import java.util.Stack;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        int[] rowIndex = new int[matrix.length];//assume all 0's by default

        int index=1;

        while(k>0){
            index = -1;

            for(int i =0; i <  rowIndex.length;++i){
                if(index == -1 && rowIndex[i] < matrix[i].length){
                    index = i;
                }
                if(rowIndex[i] < matrix[i].length&&matrix[i][rowIndex[i]]<matrix[index][rowIndex[index]]){
                    index = i;
                }
            }

            rowIndex[index]++;

            k--;

        }
        return matrix[index][rowIndex[index]-1];
    }
}

