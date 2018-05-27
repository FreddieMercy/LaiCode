package LaiOffer.Class21._MergeKSortedArray;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    private class Pair {
        public final Integer value;
        public final Integer index;
        public final Integer maxLength;

        public Pair(int value, Integer index, Integer maxLength) {
            this.index = index;
            this.value = value;
            this.maxLength = maxLength;
        }
    }

    public int[] merge(int[][] arrayOfArrays) {
        // Write your solution here
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.value - o2.value;
            }
        });
        int size = 0;
        int[] counter = new int[arrayOfArrays.length];
        int index = 0;
        for (int j = 0; j < arrayOfArrays.length; ++j) {
            if (arrayOfArrays[j].length>0) {
                pq.add(new Pair(arrayOfArrays[j][0], j, arrayOfArrays[j].length));
                counter[j]++;
                size += arrayOfArrays[j].length;
            }
        }

        int[] ans = new int[size];

        while (!pq.isEmpty()) {
            Pair tmp = pq.poll();
            ans[index] = tmp.value;
            index++;
            if (counter[tmp.index] < tmp.maxLength) {
                pq.add(new Pair(arrayOfArrays[tmp.index][counter[tmp.index]], tmp.index, tmp.maxLength));
                counter[tmp.index]++;
            }

        }

        return ans;
    }
}