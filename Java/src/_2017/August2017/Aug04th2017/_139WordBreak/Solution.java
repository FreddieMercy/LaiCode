/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug04th2017._139WordBreak;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean visited[] = new boolean[s.length()+1];
        visited[0] = true;
        for(int i = 1; i <= s.length();++i){
            for(int j = 0; j < i; ++j){
                if(visited[j]&&wordDict.contains(s.substring(j, i))){
                    visited[i] = true;
                    break;
                }
            }
        }
        return visited[s.length()];
    }
}