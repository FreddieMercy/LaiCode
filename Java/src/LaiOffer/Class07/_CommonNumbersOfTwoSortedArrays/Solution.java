/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaiOffer.Class07._CommonNumbersOfTwoSortedArrays;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < A.size() && j < B.size()) {
            if (A.get(i) == B.get(j)) {
                ans.add(A.get(i));
                i++;
                j++;
            } else {
                if (A.get(i) < B.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        return ans;

    }
}