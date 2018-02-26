/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug06th2017._202HappyNumber;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> m = new HashSet<Integer>();
        int tmp = n;
        String s = ""+tmp;
        while(tmp!=1){
            if(!m.contains(tmp)){
                m.add(tmp);
                int sth = 0;
                for(char c : s.toCharArray()){
                    sth+=Math.pow((c-'0'),2);
                }
                tmp = sth;
                s = ""+tmp;
            }
            else{
                return false;
            }
        }
        return true;
    }
}