package LaiOffer.Class24._2SumAllPairII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // Write your solution here.
        List<List<Integer>> ans = new ArrayList<>();
        if (array != null) {
            Arrays.sort(array);
        }

        int i = 0;
        int j = array.length - 1;

        int sum;
        while (i < j) {

            sum = array[i] + array[j];
            if (sum == target) {
                ans.add(Arrays.asList(array[i], array[j]));
                i++;
                j--;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
            while (i > 0 && i < array.length && array[i] == array[i - 1]) {
                i++;
            }

            while (j >= 0 && j < array.length - 1 && array[j + 1] == array[j]) {
                j--;
            }
        }

        return ans;
    }
}