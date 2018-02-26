/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug03rd2017._131PalindromePartitioning;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if(s.length()<=1){
            List<String> tmp = new ArrayList<String>();
            tmp.add(s);
            ret.add(tmp);
        }
        else{
            for(int i = 1; i <= s.length();++i){
                if(s.substring(0,i).equals(new StringBuilder(s.substring(0,i)).reverse().toString())){
                    List<String> tmp = new ArrayList<String>();
                    tmp.add(s.substring(0,i));
                    List<String> tmp2 = new ArrayList<String>(tmp);
                    List<List<String>> tmp3 = this.partition(s.substring(i, s.length()));
                    if(s.substring(i, s.length()).length() == 0)
                    {
                        ret.add(tmp);
                    }
                    else if(tmp3.size()==0)
                    {
                        tmp.add(s.substring(i, s.length()));
                        ret.add(tmp);
                    }
                    else{
                        for(List<String> t :tmp3){
                            tmp2.addAll(t);
                            ret.add(tmp2);
                            tmp2 = new ArrayList<String>(tmp);
                        }
                    }
                }
            }
        }
        return ret;
    }
}