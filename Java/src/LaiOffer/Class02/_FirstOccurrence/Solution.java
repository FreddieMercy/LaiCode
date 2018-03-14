/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaiOffer.Class02._FirstOccurrence;

/**
 *
 * @author junhaozhang
 */
public class Solution {
    private int binarySearchHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (array == null || array.length == 0) {
            return -1;
        }

        int mid = (right-left)/2+left;
        if (array[mid] == target) {
            while(mid >=0 && array[mid] == target)
            {
                mid--;
            }
            return mid+1;
        }

        if (array[mid] > target) {
            return binarySearchHelper(array, target, left, mid - 1);
        }

        return binarySearchHelper(array, target, mid + 1, right);

    }

    public int firstOccur(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        return binarySearchHelper(array, target, 0, array.length-1);
    }
}
