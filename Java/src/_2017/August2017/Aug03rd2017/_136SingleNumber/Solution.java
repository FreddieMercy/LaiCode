/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug03rd2017._136SingleNumber;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> m = new HashSet<Integer>();
        for(int n : nums){
            if(!m.contains(n)){
                m.add(n);
            }
            else{
                m.remove(n);
            }
        }
        
        return (int)m.toArray()[0];
    }
}