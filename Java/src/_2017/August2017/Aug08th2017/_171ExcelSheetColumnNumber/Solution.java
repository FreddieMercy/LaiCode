/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug08th2017._171ExcelSheetColumnNumber;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public int titleToNumber(String s) {
        int cof = s.length()-1;
        if(cof <0){
            return 0;
        }
        
        int ans = 0;
        
        for(char c : s.toCharArray()){
            ans+=(c-64)*Math.pow(26, cof);
            cof--;
        }
        
        return ans;
    }
}