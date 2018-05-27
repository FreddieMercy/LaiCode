package LaiOffer.Class18._ArrayDeduplicationI;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int[] dedup(int[] array) {
        // Write your solution here
        int i = 0;
        if(array == null || array.length <=1){
            return array;
        }
        for(int j = 1; j < array.length;++j){
            if(array[i]!=array[j]){
                array[++i] = array[j];
            }
        }

        return Arrays.copyOfRange(array, 0, i+1);
    }
}
