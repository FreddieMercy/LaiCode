/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug08th2017._172FactorialTrailingZeroes;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        int tmp = n;
        
        while(tmp>0){
            ans+=tmp/5;
            tmp/=5;
        }
        
        
        return ans;
    }
}