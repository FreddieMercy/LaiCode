/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaiOffer.Class2._ClosestInSortedArray;
import java.lang.*;

/**
 *
 * @author junhaozhang
 */

public class Solution {
    private  int binarySearchHelper(int[] array, int target, int left, int right, int tracker, int last) {
        if (left > right) { //finished the whole array, return
            return last;
        }
        if (array == null || array.length == 0) {
            return -1;
        }

        int mid = (right-left)/2+left; //mid point of the searching region
        int diff = Math.abs( array[mid] - target);
        if (diff > tracker ) {   //if ever the difference between the current value and the target increase, then return the LAST index it had been.
            return binarySearchHelper(array, target, mid+1, last, last, last);
        }

        //otherwise, keep searching
        if (array[mid] > target) {
            return binarySearchHelper(array, target, left, mid - 1, diff, mid);
        }

        return binarySearchHelper(array, target, mid + 1, right, diff, mid);

    }

    public  int closest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        return binarySearchHelper(array, target, 0, array.length-1, Integer.MAX_VALUE, -1);
    }
}
