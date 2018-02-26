/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug07th2017._152MaximumProductSubarray;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhao.zhang.freddie
 */
/*
public class Solution {
    private Map<Integer, Map<Integer,Integer>> m = new HashMap<Integer, Map<Integer, Integer>>();
    private int finalMax(int start, int[] rest){
        int max = start;
        int tmp = start;
        for(int i : rest){
            tmp*=i;
            max = Math.max(max, tmp);
        }        
        return max;
    }
    
    public int maxProduct(int[] nums) { 
        return this.finalMax(nums[0], Arrays.copyOfRange(nums, 1, nums.length));
    }
}
*/

public class Solution {
    
    public int maxProduct(int[] nums) {
        int index = 1;
        int max = nums[0]; 
        int min = max;
        int current = max;
        while(index< nums.length){
            if(nums[index] < 0){
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[index], max*nums[index]);
            min = Math.min(nums[index], min*nums[index]);
            current = Math.max(current, max);
            index++;
        }        
        return current;
    }
}
