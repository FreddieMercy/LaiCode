/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaiOffer.Class01._MergeSort;

import java.util.Arrays;

/**
 *
 * @author junhaozhang
 */


public class Solution {
    private void mergellTogether(int[] array, int[] tmp, int left,int mid, int right) {
        for (int i = left; i <= right; ++i) {
            tmp[i] = array[i];
        }

        int rightIndex = mid+1;
        int leftIndex = left;

        while (leftIndex <= mid && rightIndex <= right) {

            if (tmp[leftIndex] < tmp[rightIndex]) {
                array[left] = tmp[leftIndex];
                leftIndex++;
            } else {
                array[left] = tmp[rightIndex];
                rightIndex++;
            }
            left++;

        }

        while (leftIndex <= mid) {
            array[left] = tmp[leftIndex];
            leftIndex++;
            left++;
        }
    }

    private void splitHalf(int[] array, int[] tmp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        splitHalf(array, tmp, left, mid);
        splitHalf(array, tmp, mid + 1, right);
        mergellTogether(array, tmp, left,mid, right);
    }

    public int[] mergeSort(int[] array) {
        // Write your solution here.
        if (array.length == 0 || array == null ) {
            return array;
        }
        int[] tmp = new int[array.length];

        splitHalf(array, tmp, 0, array.length-1);

        return array;
    }
}


/*
public class Solution {
    private int[] mergeSortHelper(int[] array, int left, int right) {

        int length = right-left+1; //calculate the size of the array this should return
        int[] ans = new int[length]; //initialize the return array

        if (length==1) { //if only one element (i.e: split to the very end)
            ans[0] = array[left];
        } else {
            int mid = (length-1)/2;
            //split the existing string to two sub-arrays equally
            int[] tmp_LeftHalf = mergeSortHelper(array, left, left+mid);
            int[] tmp_RigtHalf = mergeSortHelper(array, left+mid + 1, right);

            int l = 0, r = 0;

            for(int i = 0; i < length;++i){

                //if one of those two sub-arrays finished, append all the rest of another sub-array into the return array sequentially
                if(l>=tmp_LeftHalf.length){
                    while(r<tmp_RigtHalf.length){
                        ans[i] = tmp_RigtHalf[r];
                        ++i;
                        ++r;
                    }
                    break;
                }
                if(r>=tmp_RigtHalf.length){
                    while(l<tmp_LeftHalf.length){
                        ans[i] = tmp_LeftHalf[l];
                        ++i;
                        ++l;
                    }
                    break;
                }

                //compare one element from each of those two arrays and compare, the lesser goes to the return array sequentially
                if(tmp_LeftHalf[l]<tmp_RigtHalf[r]){
                    ans[i] = tmp_LeftHalf[l];
                    l++;
                }
                else{
                    ans[i] = tmp_RigtHalf[r];
                    r++;
                }
            }
        }

        return ans;

    }

    public int[] mergeSort(int[] array) {
        // Write your solution here.
        if (array.length == 0 || array == null) {
            return array;
        }
        return mergeSortHelper(array, 0, array.length-1);
    }
}

*/