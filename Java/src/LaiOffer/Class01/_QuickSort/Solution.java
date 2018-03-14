/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaiOffer.Class01._QuickSort;

import java.util.Random;

/**
 *
 * @author junhaozhang
 */

public class Solution {
    private void swap(int[] array, int from, int to){
        if(array==null || from <0 || to<0 || from > array.length-1 || to>array.length-1){
            throw new ArrayIndexOutOfBoundsException();
        }

        int tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }

    private int partation(int[] array, int start, int end) {

        swap(array, (new Random().nextInt(end - start)) + start, end);

        int i = start;
        int j = end;

        while (i < j) {

            while (i < j && array[i] <= array[end]) {
                i++;
            }

            while (j > i && array[j] >= array[end]) {
                j--;
            }

            if (j > i) {
                swap(array, j, i);
            }
        }

        swap(array, i, end);

        return i;
    }

    private void quickSortHelper(int[] array, int start, int end) {
        if (start >= end || array == null) {//Error Handling
            return;
        }

        int pivotIndex = partation(array,start,end);
        quickSortHelper(array,start,pivotIndex-1);
        quickSortHelper(array,pivotIndex+1,end);

    }
    public int[] quickSort(int[] array) {
        // Write your solution here
        if (array == null||array.length <=1) {//Error Handling
            return array;
        }
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }
}

/*
public class Solution {
    private void quickSortHelper(int[] array, int start, int end) {
        if (start >= end || array == null) {//Error Handling
            return;
        }

        int i = start, j = end; //two pointers point the start and end positions of the array

        while (i < j) { //if i and j cross-overed, then stop
            while (array[i] <= array[end] && i < end) {//finding the element that is greater than pivot(array[end])
                i++;
            }

            while (array[j] >= array[end] && j >start) {//find the element that is LESSER than the pivot(array[end])
                j--;
            }

            if(i<j) { //if i and j haven't cross-over, then swap
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        int tmp = array[i];

        //swap the pivot with the last element that i points at which is greater than pivot.
        array[i] = array[end];
        array[end] = tmp;

        quickSortHelper(array, start, i-1);
        quickSortHelper(array, i+1 , end);

    }
    public int[] quickSort(int[] array) {
        // Write your solution here
        if (array == null||array.length <=1) {//Error Handling
            return array;
        }
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }
}
*/