/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug07th2017._162FindPeakElement;

/**
 *
 * @author junhaozhang
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int ans = 1;
        while(ans < nums.length && nums[ans-1] <= nums[ans]){
            ans++;
        }
        return ans-1;
    }
}