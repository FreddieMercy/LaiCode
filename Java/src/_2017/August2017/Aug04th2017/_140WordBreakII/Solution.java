/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug04th2017._140WordBreakII;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    private Map<Integer, List<String>> m = new HashMap<Integer, List<String>>();
    private Integer Length = -1;
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> tmp = new ArrayList<String>();
        if(Length<0){
            Length = s.length();
        }
        if(m.containsKey(Length-s.length())){
            return m.get(Length-s.length());
        }
        if(wordDict.contains(s)){
            tmp.add(s);
        }
        for(int i = 1; i < s.length();++i){
            if(wordDict.contains(s.substring(0, i))){
                for(String sth : this.wordBreak(s.substring(i, s.length()), wordDict)){
                    tmp.add(s.substring(0, i)+" "+sth);
                }
            }            
        }
        m.put(Length-s.length(), tmp);
        return tmp;
    }
}