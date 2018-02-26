/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug08th2017._169MajorityElement;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int tar = nums.length/2;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        for(int i : nums){
            if(!m.containsKey(i)){
                m.put(i, 1);
            }
            else{
                m.put(i, m.get(i)+1);
            }
            if(m.get(i)>tar){
                return i;
            }
        }
        
        return 0;
    }
}
/*
public class Solution {
    public int majorityElement(int[] nums) {        
        Arrays.sort(nums);        
        return nums[nums.length / 2];        
    }
}
*/