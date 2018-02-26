/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug05th2017._179LargestNumber;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    class Comp implements Comparator<Integer>{
        public int compare(Integer a, Integer b)
        {
            String x = ""+a;
            String y = ""+b;
            int indexX = 0;
            int indexY = 0;
            
            while((indexX < x.length()-1 || indexY < y.length()-1) && (x.toCharArray()[indexX]-'0') - (y.toCharArray()[indexY]-'0')==0){
                indexX++;
                indexY++;
                if(indexX > x.length()-1){
                    x += ""+a;
                }
                if(indexY > y.length()-1){
                    y += ""+b;
                }
            }
            
            return (y.toCharArray()[indexY]-'0')-(x.toCharArray()[indexX]-'0');
        } 
    }
    public String largestNumber(int[] nums) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for(int i : nums){
            ar.add(i);
        }
        Collections.sort(ar, new Comp());
        String ans = "";
        
        for(int i : ar){
            if(!ans.equals("0") || i != 0){
                ans+=i;
            }
        }
        
        return ans;
    }
}