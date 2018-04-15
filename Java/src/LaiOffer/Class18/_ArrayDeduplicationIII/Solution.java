package LaiOffer.Class18._ArrayDeduplicationIII;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int[] dedup(int[] array) {
        // Write your solution here
        int i = 0;
        if(array == null || array.length <=1){
            return array;
        }
        int j = 0;
        while(j < array.length){
            int tmp = j;
            while(j < array.length && array[j] == array[tmp]){
                j++;
            }

            if(j-1==tmp) {
                array[i++] = array[tmp];
            }
        }

        return Arrays.copyOfRange(array, 0, i);
    }
}
