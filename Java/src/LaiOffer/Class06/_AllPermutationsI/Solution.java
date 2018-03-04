/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
 */
package LaiOffer.Class6._AllPermutationsI;
import java.util.List;
import java.util.ArrayList;
/**
 *
@author junhaozhang
 */

public class Solution {
    public List<String> permutations(String set) {
        // Write your solution here
        List<String> ans = new ArrayList<String>();
        if (set != null) {

            if (set.length() == 0) {
                ans.add("");
            } else {
                for (int i = 0; i < set.length(); ++i) {
                    String t = set.substring(0, i) + set.substring(i + 1, set.length());
                    for (String s : permutations(t)) {
                        ans.add(set.charAt(i) + s);
                    }
                }
            }
        }
        return ans;
    }
}