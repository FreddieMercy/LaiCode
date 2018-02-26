/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.July2017.July30th2017._118PascalsTriangle;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows;++i){
            switch(i){
                case 0:
                    ans.add(Arrays.asList(1));
                    break;
                case 1:
                    ans.add(Arrays.asList(1,1));
                    break;
                default:
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(1);
                    for(int j = 1; j < ans.get(i-1).size();++j)
                    {
                        tmp.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                    }
                    tmp.add(1);
                    ans.add(tmp);
                    break;
            }
        }
        return ans;
    }
}