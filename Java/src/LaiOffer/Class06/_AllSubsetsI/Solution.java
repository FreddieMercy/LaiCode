/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
 */
package LaiOffer.Class6._AllSubsetsI;
import java.util.List;
import java.util.ArrayList;
/**
 *
@author junhaozhang
 */

public class Solution {
    public List<String> subSets(String set) {
        // Write your solution here
        List<String> ans = new ArrayList<>();
        if(set == null){
            return ans;
        }
        ans.add("");
        findSubsets(set, 0, ans);
        return ans;
    }
    private void findSubsets(String s,int start, List<String> list){
        if(start >= s.length()){
            return;
        }
        int cur = list.size()-1;
        for(int i = start; i < s.length(); ++i){
            list.add(list.get(cur)+s.toCharArray()[i]);
            findSubsets(s, i+1, list);

        }

    }
}
