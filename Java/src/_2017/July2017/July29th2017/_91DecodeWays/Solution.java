/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.July2017.July29th2017._91DecodeWays;
import java.util.*;
/**
 *
 * @author junhaozhang
 */

public class Solution {
    private Map<String,Integer> m = new HashMap<String, Integer>();
    private int dfs(String s){
        if(m.containsKey(s)){
            return m.get(s);
        }
        if(s.length() ==0){
            return 1;
        }
        if(s.toCharArray()[0]=='0')
        {
            return 0;
        }
        if(s.length() ==1){
            return 1;
        }
        int total = 0;
        if(Integer.parseInt(Character.toString(s.toCharArray()[0])+Character.toString(s.toCharArray()[1])) <=26){
            total+=this.dfs(s.substring(2));
        }

        total+=this.dfs(s.substring(1));
        m.put(s, total);
        return total;
    }
    public int numDecodings(String s) {
        if(s.length()==0 || s.toCharArray()[0]=='0')
        {
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }

        return this.dfs(s);
    }
}