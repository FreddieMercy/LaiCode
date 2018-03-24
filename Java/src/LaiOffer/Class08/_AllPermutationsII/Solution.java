package LaiOffer.Class08._AllPermutationsII;
import java.util.*;

public class Solution {
    private void swap(char[] s, int i, int j){
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
    private void helper(char[] s, int index, List<String> ans){
        if(index >= s.length){
            ans.add(new String(s));
            return;
        }
        Set<Character> c = new HashSet<>();
        for(int i = index; i < s.length;++i){
            if(c.add(s[i])){
                swap(s, i, index);
                helper(s, index+1, ans);
                swap(s, i, index);
            }
        }

    }

    public List<String> permutations(String set) {
        // Write your solution here.
        List<String> ans = new ArrayList<>();
        if(set == null){
            return ans;
        }
        char[] s = set.toCharArray();
        helper(s, 0, ans);
        return ans;
    }
}






