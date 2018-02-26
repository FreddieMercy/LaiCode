/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug09th2017._240SearchA2DMatrixII;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
/*
        //int [][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        //System.out.println(x.searchMatrix(matrix, 5));
        
        //int [][] matrix = {{1,1}};
        //System.out.println(x.searchMatrix(matrix, 2));
        int [][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(x.searchMatrix(matrix, 15));
*/
public class Solution {
    private int[][] _matrix;
    private boolean existInCol(int x, int y, int target){
        for(int i = x-1; i >=0; --i){
            if(_matrix[i][y] < target){
                return false;
            }
            if(_matrix[i][y] == target){
                return true;
            }
        }
        return false;
    }
    private boolean existInRow(int x, int y, int target){
        for(int i = y-1; i >=0; --i){
            if(_matrix[x][i] < target){
                return false;
            }
            if(_matrix[x][i] == target){
                return true;
            }
        }
        return false;
    } 
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length == 0){
            return false;
        }
        _matrix = matrix;
        int x = 0;
        int y = 0;
        while(x<matrix.length - 1||y<matrix[0].length - 1){
            if(target == _matrix[x][y]||(target < _matrix[x][y] && (this.existInCol(x, y, target) || this.existInRow(x, y, target)))){
                return true;
            }
            if(x<matrix.length - 1){
                x++;
            }
            if(y<matrix[0].length - 1){
                y++;
            }
        }
            if(target == _matrix[x][y]||(target < _matrix[x][y] && (this.existInCol(x, y, target) || this.existInRow(x, y, target)))){
                return true;
            }
        return false;
    }
}

//using binary search
/*
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int column = matrix[0].length - 1;
        int row = 0;
        while(column >=0 && row < matrix.length){
            if(target == matrix[row][column]){
                return true;
            } else if (target < matrix[row][column]) {
                column --;
            } else if (target > matrix[row][column]) {
                row ++;
            }
        }
        return false;
    }
}
*/