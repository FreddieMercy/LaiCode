package LaiOffer.Class10._SpiralOrderTraverseI;

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int start = 0;
        int end = matrix.length - 1;


        while (start < end) {
            for (int i = start; i < end; ++i) {
                ans.add(matrix[start][i]);
            }
            for (int i = start; i < end; ++i) {
                ans.add(matrix[i][end]);
            }
            for (int i = end; i > start; --i) {
                ans.add(matrix[end][i]);
            }
            for (int i = end; i > start; --i) {
                ans.add(matrix[i][start]);
            }

            start++;
            end--;
        }

        if (start == end) {
            ans.add(matrix[start][end]);
        }


        return ans;
    }
}
/*
public class Solution {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        Traverse(matrix, 0, matrix.length - 1, ans);
        return ans;
    }

    private void Traverse(int[][] matrix, int x, int y, List<Integer> ans) {

        if (y < 0) {
            return;
        }

        if (y==0) {
            ans.add(matrix[x][x]);
            return;
        }

        for (int i = 0; i < y; ++i) {
            ans.add(matrix[x][x+i]);
        }
        for (int i = 0; i < y; ++i) {
            ans.add(matrix[x+i][x+y]);
        }

        for (int i = 0; i < y; ++i) {
            ans.add(matrix[x+y][x+y - i]);
        }
        for (int i = 0; i < y; ++i) {
            ans.add(matrix[x+y - i][x]);
        }
        Traverse(matrix, x + 1, y - 2, ans);
    }
}
*/
/*
public class Solution {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        top(0, 0, matrix.length, matrix, ans);
        return ans;
    }

    private void top(int startX, int startY, int length, int[][] array, List<Integer> ans){

        if(array==null || length<0){
            return;
        }
        length--;
        if(length ==0){
            ans.add(array[startY][startX]);
            return;
        }
        for(int i = 0; i < length;++i){
            ans.add(array[startY][startX+i]);
        }

        right(startX+length, startY, length, array, ans);
    }
    private void right(int startX, int startY, int length, int[][] array,List<Integer> ans){

        if(array==null || length<0){
            return;
        }
        if(length ==0){
            ans.add(array[startY][startX]);
            return;
        }
        for(int i = 0; i < length;++i){
            ans.add(array[startY+i][startX]);
        }

        bot(startX, startY+length, length, array, ans);
    }
    private void bot(int startX, int startY, int length, int[][] array,List<Integer> ans){

        if(array==null || length<0){
            return;
        }
        if(length ==0){
            ans.add(array[startY][startX]);
            return;
        }
        for(int i = 0; i < length;++i){
            ans.add(array[startY][startX-i]);
        }

        left(startX-length, startY, length, array, ans);
    }
    private void left(int startX, int startY, int length, int[][] array,List<Integer> ans){

        if(array==null || length<0){
            return;
        }
        if(length ==0){
            ans.add(array[startY][startX]);
            return;
        }

        for(int i = 0; i < length;++i){
            ans.add(array[startY-i][startX]);
        }

        length--;

        top(startX+1, startY-length, length, array, ans);
    }
}



*/