package LaiOffer.Class18._ArrayDeduplicationIV;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] dedup(int[] array) {
        // Write your solution here
        int j = -1;
        int i =0;
        if (array == null || array.length <= 1) {
            return array;
        }
        Deque<Integer> stack = new LinkedList<>();

        while (i < array.length) {
            int tmp = i;
            boolean poped = false;
            if (j >= 0 && array[j] == array[tmp]) {
                j--;
                poped = true;
            }
            while (i < array.length && array[i] == array[tmp]) {
                i++;
            }
            if (i - tmp == 1&&!poped) {
                array[++j] = array[tmp];
            }
        }

        return Arrays.copyOfRange(array, 0, j+1);
    }
}
/*
public class Solution {
    public int[] dedup(int[] array) {
        // Write your solution here
        int i = 0;
        if (array == null || array.length <= 1) {
            return array;
        }
        int j = 0;
        boolean foundDup = false;
        while (j < array.length) {
            int tmp = j;
            while (!foundDup&&j < array.length && array[j] == array[tmp]) {
                j++;
            }

            if (foundDup || j - 1 == tmp) {
                array[i++] = array[tmp];
                if(foundDup){
                    j++;
                }
            } else {
                foundDup = true;
            }
        }

        return (foundDup)?dedup(Arrays.copyOfRange(array, 0, i)):Arrays.copyOfRange(array, 0, i);
    }
}
*/