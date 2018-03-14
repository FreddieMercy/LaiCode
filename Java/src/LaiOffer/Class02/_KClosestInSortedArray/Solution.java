/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaiOffer.Class02._KClosestInSortedArray;

/**
 *
 * @author junhaozhang
 */
public class Solution {
    private int[] find(int[] array, int k, int last, int target) {
        int[] ans = new int[k];
        int index = 0;
        int l = last, r = last;
        while (k > 0) {

            if (l == r) {
                ans[index] = array[last];
                r++;
                l--;
            } else {
                if (r < array.length) {
                    if (l >= 0 && Math.abs(target - array[l]) <= Math.abs(target - array[r])) {
                        ans[index] = array[l];
                        l--;
                    } else {
                        ans[index] = array[r];
                        r++;
                    }
                } else {
                    if (r < ans.length && Math.abs(target - array[l]) >= Math.abs(target - array[r])) {
                        ans[index] = array[r];
                        r++;
                    } else {
                        ans[index] = array[l];
                        l--;
                    }
                }
            }
            index++;
            k--;
        }

        return ans;
    }
    private  int binarySearchFindCloest(int[] array, int target, int left, int right, int tracker, int last) {
        if (left > right) { //finished the whole array, return
            return last;
        }
        if (array == null || array.length == 0) {
            return -1;
        }

        int mid = (right-left)/2+left; //mid point of the searching region
        int diff = Math.abs( array[mid] - target);
        if (diff > tracker ) {   //if ever the difference between the current value and the target increase, then return the LAST index it had been.
            return binarySearchFindCloest(array, target, mid+1, last, last, last);
        }

        //otherwise, keep searching
        if (array[mid] > target) {
            return binarySearchFindCloest(array, target, left, mid - 1, diff, mid);
        }

        return binarySearchFindCloest(array, target, mid + 1, right, diff, mid);

    }
    private int[] binarySearchHelper(int[] array, int target, int left, int right, int tracker, int last, int k) {
        if (left > right) {
            return find(array, k, last, target);
        }
        if (array == null || array.length == 0) {
            return new int[0];
        }

        int mid = (right - left) / 2 + left;
        int diff = Math.abs(array[mid] - target);
        if (diff > tracker) {
            return find(array, k, binarySearchFindCloest(array, target, mid+1, last, last, last), target);
        }

        if (array[mid] > target) {
            return binarySearchHelper(array, target, left, mid - 1, diff, mid, k);
        }

        return binarySearchHelper(array, target, mid + 1, right, diff, mid, k);

    }

    public int[] kClosest(int[] array, int target, int k) {
        if (k > array.length) {
            return array;
        }
        if (array == null || array.length == 0) {
            return new int[0];
        }
        return binarySearchHelper(array, target, 0, array.length - 1, Integer.MAX_VALUE, -1, k);
    }
}

