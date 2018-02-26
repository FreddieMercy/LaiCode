/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug09th2017._279PerfectSquares;

/**
 *
 * @author junhaozhang
 */
public class Solution {
    private boolean findTwo(int n){
        int root = (int)Math.sqrt(n);
        int m = n-root*root;
        int s = (int)Math.sqrt(m);
        while(root*root*2>=n){
            int tmpm = n-root*root;
            int tmproot = (int)Math.sqrt(tmpm);
            if(tmproot*tmproot == tmpm){
                return true;
            }
            root--;
        }
        return false;
    }
    public int numSquares(int n) {
        int root = (int)Math.sqrt(n);
        if(root*root == n){
            return 1;
        }
        if(this.findTwo(n)){
            return 2;
        }
        while(root*root*3>=n){
            if(this.findTwo(n-root*root)){
                return 3;
            }
            root--;
        }
        return 4;
    }
}
