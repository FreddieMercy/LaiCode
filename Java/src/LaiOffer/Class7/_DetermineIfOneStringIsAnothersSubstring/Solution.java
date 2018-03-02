package LaiOffer.Class7._DetermineIfOneStringIsAnothersSubstring;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int strstr(String large, String small) {
        // Write your solution here
        if (small == null || large == null) {
            return -1;
        }

        if (small == "") {
            return 0;
        }

        for (int i = 0; i + small.length() <= large.length(); ++i) {
            if (equals(large,i,small)) {

                return i;
            }
        }

        return -1;
    }

    private boolean equals(String l, int index, String s){
        if(l.length()< index+s.length()){

            return false;
        }
        for(int i = index; i < index + s.length(); ++i){
            if(l.toCharArray()[i] != s.toCharArray()[i-index]){
                return false;
            }
        }

        return true;

    }
}