/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug01st2017._128LongestConsecutiveSequence;
import java.lang.*;
import java.util.*;
import java.util.stream.Collector;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        int tmp[] = nums;
        Arrays.sort(tmp);
        if(tmp.length == 0)
        {
            return 0;
        }
        int ans = 1;
        int sth = 1;
        for(int i = 1; i < tmp.length;++i){
            if(tmp[i]-1 == tmp[i-1]){
                sth++;
            }
            else if(tmp[i]!=tmp[i-1]){
                ans = Math.max(ans, sth);
                sth = 1;
            }
        }
        
        return Math.max(ans, sth);
    }
}