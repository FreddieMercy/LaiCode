/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug09th2017._242ValidAnagram;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] m = s.toCharArray();
        char[] n = t.toCharArray();
        Arrays.sort(m);
        Arrays.sort(n);
        return Arrays.equals(m,n);
    }
}