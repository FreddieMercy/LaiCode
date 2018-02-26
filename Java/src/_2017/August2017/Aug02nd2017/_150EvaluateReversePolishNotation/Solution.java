/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug02nd2017._150EvaluateReversePolishNotation;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhao.zhang.freddie
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : tokens){
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                if(stack.size()<2){
                    System.out.println("Fucked up!! No enough nums!!");
                }
                int y = stack.pop();
                int x = stack.pop();
                switch(s){
                    case "+":
                       stack.push(x+y);
                       break;
                    case "-":
                       stack.push(x-y);
                       break;
                    case "*":
                       stack.push(x*y);
                       break;
                    case "/":
                       stack.push(x/y);
                       break;
                    default:
                        System.out.println("Fucked up!!");
                }
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}