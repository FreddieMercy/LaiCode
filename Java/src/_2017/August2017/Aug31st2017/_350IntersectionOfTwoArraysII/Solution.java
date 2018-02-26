/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug31st2017._350IntersectionOfTwoArraysII;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhao.zhang.freddie
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0){
            return new int[0];
        }
        int[] ans = new int[nums1.length];
        int end = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = 0; int n2 = 0;
        while(n1<nums1.length && n2 < nums2.length){
            if(nums1[n1]==nums2[n2]){
                ans[end] = nums1[n1];
                end++;
                n1++;
                n2++;
            }
            else if(nums1[n1]<nums2[n2]){
                n1++;
            }
            else{
                n2++;
            }
        }
        return Arrays.copyOfRange(ans, 0, end);
    }
}