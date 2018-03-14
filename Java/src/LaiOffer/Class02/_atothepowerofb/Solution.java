/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaiOffer.Class02._atothepowerofb;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author junhaozhang
 */
public class Solution {
    public long power(int a, int b) {
        return power((long) a, b);
    }

    private long power(long a, int b) {
        if (b == 0) {
            return 1;
        }

        if (a == 0) {
            return a;
        }

        int c = Math.abs(b);
        long ans = 1;
        Deque<Integer> stack = new LinkedList<>();

        while (c > 0) {
            stack.push(c % 2);
            c /= 2;
        }

        while (!stack.isEmpty()) {
            ans = ans * ans * ((stack.poll()==1)?a:1);
        }


        if (b < 0) {
            return 1 / ans;
        }

        return ans;
    }
}


/*
public class Solution {
    public long power(int a, int b) {
        int cof = b;
        long ans = 1;
        if(b<0){
            cof = Math.abs(b);
        }

        if(cof == 0){
            return 1;
        }
        if(a==1 || a==0){
            return a;
        }

        if(cof%2==1){
            ans = power(a,cof/2)*power(a, cof/2)*a;

        }
        else{
            ans = power(a,cof/2)*power(a, cof/2);
        }

        if(b<0){
            return 1/ans;
        }
        return ans;
    }
}
*/