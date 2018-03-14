/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaiOffer.Class01._SelectionSort;
import java.lang.*;

/**
 *
 * @author junhaozhang
 */

public class Solution {
    private void selectionSort(int[] array){
        //error handling
        if (array.length == 0 || array == null /*Just in case... I know it is stupid lol*/) {
            return;
        }
        //"index" is the index of the minimum element in the unsorted portion of the sub-array
        //"Minimum" is the value of the minimum element in the unsorted portion of the sub-array
        int index = -1;
        int Minimum = Integer.MAX_VALUE;
        //implementing the algorithm of Selection Sort
        for(int i = 0; i < array.length; ++i){
            for(int j = i; j < array.length; ++j){
                if(array[j] < Minimum){
                    Minimum = array[j];
                    index = j;
                }
            }
            //swap the "Minimum" and the array[i]
            array[index] = array[i];
            array[i] = Minimum;

            //restore "Minimum" and "index"
            index = -1;
            Minimum = Integer.MAX_VALUE;
        }

    }

    public int[] solve(int[] array) {
        // Write your solution here.
        selectionSort(array);
        return array;
    }
}
