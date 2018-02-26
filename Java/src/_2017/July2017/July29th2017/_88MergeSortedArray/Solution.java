/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.July2017.July29th2017._88MergeSortedArray;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        for(int x : nums2){
            nums1[index+m] = x;
            index++;
        }
        Arrays.sort(nums1);
    }
}