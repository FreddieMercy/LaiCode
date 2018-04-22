package LaiOffer.Class26._MaximumValuesOfSizeKSlidingWindows;

import java.util.*;

public class Solution {
    public List<Integer> maxWindows(int[] array, int k) {
        // Write your solution here

        List<Integer> max = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < array.length; ++i) {

            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }

            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i + 1 >= k) {
                max.add(array[deque.peekFirst()]);
            }
        }

        return max;
    }
}
/*
public class Solution {
    public List<Integer> maxWindows(int[] array, int k) {
        // Write your solution here
        if (array == null || array.length < k) {
            return null;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> rm = new HashMap<>();
        for (int i = 0; i < k; ++i) {
            pq.add(array[i]);
        }

        for (int i = k; i < array.length; ++i) {
            ans.add(pq.peek());
            Integer tmp = rm.get(array[i - k]);
            if (tmp == null) {
                rm.put(array[i-k], 1);
            } else {
                rm.put(array[i-k], tmp + 1);
            }
            tmp = rm.get(pq.peek());
            while (tmp != null && tmp > 0) {

                rm.put(pq.peek(), tmp - 1);

                pq.poll();

                tmp = rm.get(pq.peek());
            }

            pq.add(array[i]);
        }
        ans.add(pq.peek());
        return ans;
    }
}
*/