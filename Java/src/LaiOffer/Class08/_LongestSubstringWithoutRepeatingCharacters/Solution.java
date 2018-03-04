package LaiOffer.Class8._LongestSubstringWithoutRepeatingCharacters;
import java.lang.Math;

public class Solution {
    public int longest(String input) {
        // Write your solution here
        int[] ascii = new int[256];//assume all ascii code

        int maxLength = 0;
        int start = 0;
        int end = 1;


        for(char c : input.toCharArray()){
            if(ascii[c] != 0){
                start = Math.max(start, ascii[c]);
            }

            ascii[c] = end;
            maxLength = Math.max(maxLength, end-start);
            end++;
        }

        return maxLength;
    }
}
