package LaiOffer.Class24._2Sum;

import java.util.Arrays;

public class Solution {
    public boolean existSum(int[] array, int target) {
        // Write your solution here
        if(array==null){
            return false;
        }
        Arrays.sort(array);
        int i = 0;
        int j = array.length-1;

        int sum = array[i]+array[j];
        while (i<j) {
            if (sum==target) {
                return true;
            }
            if(sum>target){
                sum-=array[j];
                j--;
                sum+=array[j];
            }
            else{
                sum-=array[i];
                i++;
                sum+=array[i];
            }
        }
        return false;
    }
}

/*
public class Solution {
    public boolean existSum(int[] array, int target) {
        // Write your solution here
        if(array==null){
            return false;
        }
        Arrays.sort(array);
        for (int i =0; i < array.length; ++i) {
            if (binarySearchHelper(array, target - array[i], 0, i-1) != -1 || binarySearchHelper(array, target - array[i], i+1, array.length-1)!=-1) {
                return true;
            }
        }
        return false;
    }

    private int binarySearchHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (array == null || array.length == 0) {
            return -1;
        }

        int mid = (right-left)/2+left;
        if (array[mid] == target) {
            return mid;
        }

        if (array[mid] > target) {
            return binarySearchHelper(array, target, left, mid - 1);
        }

        return binarySearchHelper(array, target, mid + 1, right);

    }
}
*/