/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug31st2017._412FizzBuzz;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhao.zhang.freddie
 */
public class Solution {
    private int end;
    private List<String> ans = new AbstractList<String>(){
        @Override
        public String get(int i){
           return ((i+1)%15==0)?"FizzBuzz":((i+1)%5==0)?"Buzz":((i+1)%3==0)?"Fizz":""+(i+1);
        }
        @Override
        public int size(){
            return end;
        }
    };
    public List<String> fizzBuzz(int n) {
        end = n;
        return ans.subList(0, end);
    }
}
/*
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<String>();
        for(int i =1;i <= n;++i){
            String tmp = "";
            if(i%3==0){
                tmp+="Fizz";
            }
            if(i%5 ==0){
                tmp +="Buzz";
            }
            
            ans.add((tmp.length()>0)?tmp:""+i);
        }
        return ans;
    }
}
*/