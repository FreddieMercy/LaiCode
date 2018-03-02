package LaiOffer.Class8._AllAnagrams;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<Integer> allAnagrams(String s, String l) {


        List<Integer> ans = new ArrayList<>();

        // Write your solution here
        if (s == null || l == null||l.length()<s.length()) {
            return ans;
        }

        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        String small = new String(tmp);

        for (int i = 0; i + small.length() <= l.length(); ++i) {
            if (equals(l,i,small)) {

                ans.add(i);
            }
        }

        return ans;
    }

    private boolean equals(String l, int index, String s){
        if(l.length()< index+s.length()){
            return false;
        }

        char[] tmp = l.substring(index, index+s.length()).toCharArray();
        Arrays.sort(tmp);
        String large = new String(tmp);

        return large.equals(s);

    }
}