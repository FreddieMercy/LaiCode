/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug06th2017._204CountPrimes;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean notPrime[] = new boolean[n];
        for(int i = 2; i <n;++i){
            if(!notPrime[i]){
                count++;
                for(int j = 2; j*i<n;++j){
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}