/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;
//import _2017.June2017.Jun10th2017._126WordLadderII.Solution;
import com.sun.tools.javac.util.ArrayUtils;
import javafx.util.Pair;

import java.lang.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 *
 * @author junhao.zhang.freddie
 */

class Solution {
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





public class Leetcode {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        StringBuilder a = new StringBuilder( "abc");
StringBuilder b = new StringBuilder( "abc");
        if(a.equals(b)){
            System.out.println(a.hashCode());
            System.out.println(b.hashCode());
        }
        else{
            System.out.println("Not equal");
        }
    }
}