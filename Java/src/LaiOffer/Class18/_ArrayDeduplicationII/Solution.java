package LaiOffer.Class18._ArrayDeduplicationII;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int[] dedup(int[] array) {
        // Write your solution here
        int i = 1;
        if(array == null || array.length <=2){
            return array;
        }
        for(int j = 2; j < array.length;++j){
            if(array[i-1]!=array[j]){
                array[++i] = array[j];
            }
        }

        return Arrays.copyOfRange(array, 0, i+1);
    }
}
