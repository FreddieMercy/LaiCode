package LaiOffer.Class16._MedianTracker;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {
    private PriorityQueue<Integer> maxQ = new PriorityQueue<>();/*new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
*/
    private PriorityQueue<Integer> minQ = new PriorityQueue<>(Comparator.reverseOrder());/*new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });
*/
    public Solution() {
        // add new fields and complete the constructor if necessary.
    }

    public void read(int value) {
        // write your implementation here.
        if (maxQ.size() > minQ.size()) {
            maxQ.add(value);
            minQ.add(maxQ.poll());
        } else {
            minQ.add(value);
            maxQ.add(minQ.poll());
        }
    }

    public Double median() {
        // write your implementation here.
        if (maxQ.isEmpty() && minQ.isEmpty()) {
            return null;
        }
        if (maxQ.size() == minQ.size()) {
            return ((double) (maxQ.peek() + minQ.peek())) / 2;
        } else {
            return (double) ((maxQ.size() > minQ.size()) ? maxQ.peek() : minQ.peek());
        }
    }
}
