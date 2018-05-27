package LaiOffer.Class24._3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    private void _2sum(int[] array, int target, int head, List<List<Integer>> ans) {

        int i = head + 1;
        int j = array.length - 1;

        int sum;
        while (i < j) {
            sum = array[i] + array[j];
            if (sum == target) {
                ans.add(Arrays.asList(array[head], array[i], array[j]));
                i++;
                while (i > 0 && i < array.length && array[i] == array[i - 1]) {
                    i++;
                }
                while (j >= 0 && j < array.length - 1 && array[j + 1] == array[j]) {
                    j--;
                }
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
    }

    public List<List<Integer>> allTriples(int[] array, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        if (array != null) {
            Arrays.sort(array);
            for (int i = 0;i < array.length;++i) {
                if(i > 0 && array[i]==array[i-1]){
                    continue;
                }
                _2sum(array, target - array[i], i, ans);
            }
        }
        return ans;
    }
}