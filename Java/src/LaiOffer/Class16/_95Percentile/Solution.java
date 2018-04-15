package LaiOffer.Class16._95Percentile;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int percentile95(List<Integer> lengths) {
        // Write your solution here.
        int limit = 4096;
        int[] counter = new int[limit+1];
        for(int i : lengths){
            counter[i]++;
        }
        int sum= 0;
        int len = limit;
        while (sum <= lengths.size()*0.05){
            sum+=counter[len--];
        }
        return ++len;
    }
}

/*
public class Solution {
    public int percentile95(List<Integer> lengths) {
        // Write your solution here.
        int counter = (int)(lengths.size()*0.05);
        PriorityQueue<Integer> minQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i : lengths){
            if(minQ.size()>counter){
                minQ.poll();
            }
            minQ.add(i);
        }
        return minQ.poll();
    }
}
*/