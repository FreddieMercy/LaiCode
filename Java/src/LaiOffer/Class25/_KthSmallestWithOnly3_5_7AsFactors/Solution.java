package LaiOffer.Class25._KthSmallestWithOnly3_5_7AsFactors;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public long kth(int k) {
        // Write your solution here

        long min = 3L * 5 * 7;
        Deque<Long> three = new LinkedList<Long>();
        Deque<Long> five =new LinkedList<Long>();
        Deque<Long> seven = new  LinkedList<Long>();
        three.add(min*3);
        five.add(min*5);
        seven.add(min*7);
        while (k > 1) {
            if (!three.isEmpty()&&three.peekFirst() < five.peekFirst() && three.peekFirst() < seven.peekFirst()) {
                long tmp = three.pollFirst();
                three.offerLast(tmp * 3);
                five.offerLast(tmp * 5);
                seven.offerLast(tmp * 7);
                min = tmp;
            } else if (!five.isEmpty()&&five.peekFirst() < seven.peekFirst()) {
                long tmp = five.pollFirst();

                five.offerLast(tmp * 5);
                seven.offerLast(tmp * 7);
                min = tmp;
            } else {
                long tmp = seven.pollFirst();
                seven.offerLast(tmp * 7);
                min = tmp;
            }
            k--;
        }
        return min;
    }
}
