/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
 */
package LaiOffer.Class07._TopKFrequentWords;
import java.util.Map;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
/**
 *
@author junhaozhang
 */

public class Solution {
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        Map<String, Integer> m = new HashMap<>();
        List<String> ans = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (String s : combo) {
            if (m.containsKey(s)) {
                m.put(s, m.get(s) + 1);
            } else {
                m.put(s, 1);
            }
        }

        for (Map.Entry<String, Integer> s : m.entrySet()) {
            q.add(s);
        }

        while (!q.isEmpty() && k > 0) {
            ans.add(q.poll().getKey());
            k--;
        }

        return ans.toArray(new String[0]);
    }
}