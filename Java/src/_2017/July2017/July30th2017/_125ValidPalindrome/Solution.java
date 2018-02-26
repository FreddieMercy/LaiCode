/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.July2017.July30th2017._125ValidPalindrome;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */

public class Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return s1.equals(new StringBuilder(s1).reverse().toString());
    }
}

/*
public class Solution {
    public boolean isPalindrome(String s) {

        int left = 0, right = s.length()-1;
        while(left < s.length() && (s.toCharArray()[left] == ' '|| (!Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left)))))
        {
            left++;
        }
            
        while(right>=0 && (s.toCharArray()[right] == ' '|| (!Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right)))))
        {
            right--;
        }
        while(left<=right)
        {
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right)))
            {
                return false;
            }
            else{
                left++;
                right--;
            }
            while(left < s.length() && (s.toCharArray()[left] == ' '|| (!Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left)))))
            {
                left++;
            }
            
            while(right>=0 && (s.toCharArray()[right] == ' '|| (!Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right)))))
            {
                right--;
            }
        }
        
        return true;
    }
}
*/