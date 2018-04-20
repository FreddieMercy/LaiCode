package LaiOffer.Class24._2SumAllPairI;

import java.util.*;

public class Solution {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // Write your solution here

        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,List<Integer> > m = new HashMap<>();

        for(int i = 0; i < array.length; ++i){
            List<Integer> tmp = m.get(target-array[i]);
            if(tmp!=null){
                for(int j : tmp){
                    ans.add(Arrays.asList(i, j));
                }
            }

            if(m.get(array[i])==null) {
                m.put(array[i], new ArrayList<>());
            }

            m.get(array[i]).add(i);
        }
     return ans;
    }
}