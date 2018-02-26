/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug31st2017._371SumOfTwoIntegers;

/**
 *
 * @author junhao.zhang.freddie
 */
public class Solution {
    public int getSum(int a, int b) {
        return (b==0)?a:getSum(a^b,(a&b)<<1);//
    }
}