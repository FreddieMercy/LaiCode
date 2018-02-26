/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug05th2017._189RotateArray;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = k%nums.length;
        int head[] = Arrays.copyOfRange(nums, nums.length-n, nums.length);
        int tail[] = Arrays.copyOfRange(nums, 0, nums.length-n);
        int index = 0;
        while(index < head.length){
            nums[index] = head[index];
            index++;
        }
        int size = index;
        while(index < size + tail.length){
            nums[index] = tail[index-size];
            index++;
        }
    }
}