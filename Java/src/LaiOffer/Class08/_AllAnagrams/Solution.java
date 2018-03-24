package LaiOffer.Class08._AllAnagrams;
import java.util.*;

public class Solution {
    public List<Integer> allAnagrams(String s, String l) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() > l.length()) {
            return ans;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer tmp = map.get(c);
            if (tmp == null) {
                map.put(c, 1);
            } else {
                map.put(c, tmp + 1);
            }
        }
        int match = 0;
        for (int i = 0; i < l.length(); ++i) {
            Integer tmp = map.get(l.charAt(i));
            if (tmp != null) {
                map.put(l.charAt(i), tmp - 1);
                if (tmp == 1) {
                    match++;
                }
            }

            if (i >= s.length()) {
                Integer sth = map.get(l.charAt(i - s.length()));
                if (sth != null) {
                    map.put(l.charAt(i - s.length()), sth + 1);
                    if (sth == 0) {
                        match--;
                    }
                }
            }

            if (match == map.size()) {
                ans.add(i +1- s.length());
            }
        }

        return ans;
    }
}

/*
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

*/