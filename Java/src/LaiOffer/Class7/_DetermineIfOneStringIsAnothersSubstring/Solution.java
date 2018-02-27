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

        for (int i = 0; i + small.length() < large.length(); ++i) {
            if (true) {

                return i;
            }
        }

        return -1;
    }
}