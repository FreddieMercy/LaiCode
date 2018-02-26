/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug10th2017._326PowerOfThree;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhao.zhang.freddie
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        double i = Math.log10(n)/Math.log10(3);
        return i == (int)i;
    }
}