package LaiOffer.Class25._LargestRectangleInHistogram;

import java.util.*;

public class Solution {
    public int largest(int[] array) {
        // Write your solution here
        if(array==null){
            return 0;
        }

        Deque<List<Integer>> queue = new LinkedList<>();
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; ++i){
            if(queue.isEmpty()){
                queue.add(Arrays.asList(array[i], i));
            }
            else{
                if(queue.peekLast().get(0) < array[i]){
                    queue.add(Arrays.asList(array[i], i));
                }
                else{
                    int carryIn = i-1;
                    int start=i;
                    while (!queue.isEmpty()&&queue.peekLast().get(0) >= array[i]){
                        ans = Math.max(ans, queue.peekLast().get(0)*(carryIn-queue.peekLast().get(1) +1));
                        start=queue.pollLast().get(1);
                    }
                    queue.add(Arrays.asList(array[i], start));
                }
            }
        }
        if(!queue.isEmpty()) {
            int carryIn = array.length-1;
            while (!queue.isEmpty()){
                ans = Math.max(ans, queue.peekLast().get(0)*(carryIn-queue.peekLast().get(1) +1));
                queue.pollLast();
            }
        }
        return ans;
    }
}
