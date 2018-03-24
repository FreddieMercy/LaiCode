package LaiOffer.Class13._DictionaryWordI;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
    private boolean exists(String s, String[] dict) {
        for (String i : dict) {
            if (s.equals(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean canBreak(String input, String[] dict) {
        // Write your solution here
        if (input == null) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (String i : dict) {
            set.add(i);
        }
        StringBuilder s = new StringBuilder(input);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int target = 1; target < dp.length; ++target) {
            for (int cur = 0; cur < target; ++cur) {
                if (dp[cur] && exists(s.substring(cur,target), dict)) {
                    dp[target] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}