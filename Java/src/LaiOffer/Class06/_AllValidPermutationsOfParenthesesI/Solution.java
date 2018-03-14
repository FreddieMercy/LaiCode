package LaiOffer.Class06._AllValidPermutationsOfParenthesesI;


import java.util.ArrayList;
import java.util.List;

public class Solution {

    private void addParenthesesByLeftOrRight(int l, int r, int n, String s, List<String> ans){
        if(r >= n && l >=n){
            ans.add(s);
            return;
        }

        if(l<n){
            addParenthesesByLeftOrRight(l+1, r, n, s+"(", ans);
        }
        if(r<l){
            addParenthesesByLeftOrRight(l, r+1, n, s+")", ans);
        }
    }
    public List<String> validParentheses(int n) {
        // Write your solution here
        List<String> ans = new ArrayList<>();
        addParenthesesByLeftOrRight(0,0,n,"",ans);
        return ans;
    }
}