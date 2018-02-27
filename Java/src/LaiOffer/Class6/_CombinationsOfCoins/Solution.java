/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
 */
package LaiOffer.Class6._CombinationsOfCoins;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
@author junhaozhang
 */

public class Solution {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> ans = new ArrayList<>();
        if (coins == null || target <= 0 || coins.length <= 0) {
            List<Integer> tmp = new ArrayList<>();
            for(int i : coins) {
                tmp.add(0);
            }
            ans.add(tmp);
            return ans;
        }

        findAllCombo(target, coins, 0, ans, new int[coins.length]);

        return ans;
    }

    private void findAllCombo(int tar, int[] coin, int start, List<List<Integer>> ans, int[] current) {

        if (start >= coin.length) {
            return;
        }

        int cur = tar;
        while (cur > 0) {
            findAllCombo(cur, coin, start + 1, ans, current.clone());
            cur -= coin[start];
            current[start]++;
            if (cur == 0) {
                List<Integer> a = new ArrayList<>();
                for (int i : current) {
                    a.add(i);
                }
                ans.add(a);
            }
        }
    }
}