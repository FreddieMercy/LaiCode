package LaiOffer.Class7._RemoveAdjacentRepeatedCharactersI;

public class Solution {
    public String deDup(String input) {
        // Write your solution here
        if (input == null) {
            return input;
        }

        String ans = "";
        char pre = '\0';

        for (char c : input.toCharArray()) {

            if (c != pre) {
                pre = c;
                ans += c;
            }

        }
        return ans;
    }
}