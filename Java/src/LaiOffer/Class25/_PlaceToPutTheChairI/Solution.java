package LaiOffer.Class25._PlaceToPutTheChairI;

import com.sun.javafx.collections.MappingChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    private void dfs(char[][] gym, Long[][] dp, int i, int j, Long value) {
        if (i < 0 || i >= gym.length || j < 0 || j >= gym[0].length) {
            return;
        }
        if (gym[i][j] != 'O' && (dp[i][j] == null || dp[i][j] > value)) {
            dp[i][j] = value;
            dfs(gym, dp, i + 1, j, value + 1);
            dfs(gym, dp, i, j + 1, value + 1);
            dfs(gym, dp, i - 1, j, value + 1);
            dfs(gym, dp, i, j - 1, value + 1);
        }
    }

    public List<Integer> putChair(char[][] gym) {
        // Write your solution here.
        if (gym == null) {
            return null;
        }
        List<Integer> ans = null;
        Long value = Long.MAX_VALUE;
        List<List<Integer>> E = new ArrayList<>();
        HashMap<Integer, HashMap<Integer, Long[][]>> dp = new HashMap<>();

        for (int i = 0; i < gym.length; ++i) {
            for (int j = 0; j < gym[0].length; ++j) {
                if (gym[i][j] == 'E') {
                    E.add(Arrays.asList(i, j));

                    if(dp.get(i) == null) {
                        dp.put(i, new HashMap<>());
                    }

                    dp.get(i).put(j, new Long[gym.length][gym[0].length]);
                    dfs(gym,  dp.get(i).get(j), i, j, 0L);
                }
            }
        }
        if (E.size() > 0) {
            for (int i = 0; i < gym.length; ++i) {
                for (int j = 0; j < gym[0].length; ++j) {
                    if (gym[i][j] =='C') {
                        Long tmp = 0L;
                        for (List<Integer> e : E) {
                            tmp +=dp.get(e.get(0)).get(e.get(1))[i][j];
                        }

                        if (tmp < value) {
                            value = tmp;
                            ans = Arrays.asList(i, j);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
