package LaiOffer.Class13._DictionaryWordI;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    private boolean exists(String s, String[] dict){
        for(String i : dict){
            if(s.equals(i)){
                return true;
            }
        }
        return false;
    }
    public boolean canBreak(String input, String[] dict) {
        // Write your solution here

        if(input==null){
            return false;
        }

        StringBuilder s = new StringBuilder(input);
        boolean [] dp = new boolean[s.length()+1];
        Deque<Integer> stack = new LinkedList<>();
        int start = 0;
        stack.push(start);

        while (!dp[s.length()-1] && !stack.isEmpty()) {
            start = stack.pop();
            dp[start] = false;
            for (int i = start; i <= s.length(); ++i) {
                if (exists(s.substring(start, i).toString(), dict)) {

                    start = i;
                    stack.push(start);
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
