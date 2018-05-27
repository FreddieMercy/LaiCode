package LaiOffer.Class25._KthClosestPointTo000;

import java.util.*;

public class Solution {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        // Write your solution here

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                double O = Math.sqrt(a[o1.get(0)] * a[o1.get(0)] + b[o1.get(1)] * b[o1.get(1)] + c[o1.get(2)] * c[o1.get(2)]);
                double N = Math.sqrt(a[o2.get(0)] * a[o2.get(0)] + b[o2.get(1)] * b[o2.get(1)] + c[o2.get(2)] * c[o2.get(2)]);
                if (O == N) {
                    return 0;
                }

                return (O > N) ? 1 : -1;
            }
        });
        List<Integer> cur = Arrays.asList(0, 0, 0);
        pq.add(cur);
        Set<List<Integer>> visited = new HashSet<>();

        while (k >0) {
            cur = pq.poll();

            List<Integer> tmp = null;
            tmp = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
            if (tmp.get(0) < a.length && visited.add(tmp)) {
                pq.add(tmp);
            }
            tmp = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
            if (tmp.get(1) < b.length && visited.add(tmp)) {
                pq.add(tmp);
            }
            tmp = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
            if (tmp.get(2) < c.length && visited.add(tmp)) {
                pq.add(tmp);
            }
            k--;
        }

        return Arrays.asList(a[cur.get(0)],b[cur.get(1)],c[cur.get(2)]);

    }
}
