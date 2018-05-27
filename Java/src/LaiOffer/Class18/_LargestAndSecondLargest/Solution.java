package LaiOffer.Class18._LargestAndSecondLargest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class MaxAndHeap{
    public int min = Integer.MIN_VALUE;
    public Integer i;
    public MaxAndHeap(int j){
        i = j;
    }
    public void compare(int j) {
        /*
        if (i == j) {
            return;
        }
        */
        if (i < j) {
            min = i;
            i = j;
        } else {
            min = Math.max(min, j);
        }
    }

    public void compare(MaxAndHeap j){
        /*
if(this == j){
    return;
}
*/
if(i<j.i){
            min = Math.max( j.min, i);
            i = j.i;
        }
        else {
            min = Math.max(min, j.i);
        }
    }
}
public class Solution {
    private int[] largestAndSecond(List<MaxAndHeap> array) {
        // Write your solution here
        if (array.size() == 1) {
            return new int[]{array.get(0).i, array.get(0).min};
        }
        List<MaxAndHeap> ans = new ArrayList<>();

        for (int i = 0; i < array.size() - 1; i += 2) {
            MaxAndHeap tmp = array.get(i);
            tmp.compare(array.get(i + 1));
            ans.add(tmp);
        }
        if (array.size() % 2 == 1) {
            ans.get(ans.size() - 1).compare(array.get(array.size() - 1));
        }
        return largestAndSecond(ans);
    }

    public int[] largestAndSecond(int[] array) {
        // Write your solution here
        if (array == null || array.length < 2) {
            return array;
        }
        List<MaxAndHeap> ans = new ArrayList<>();

        for (int i = 0; i < array.length - 1; i += 2) {
            MaxAndHeap tmp = new MaxAndHeap(array[i]);
            tmp.compare(array[i + 1]);
            ans.add(tmp);
        }
        if (array.length % 2 == 1) {
            ans.get(ans.size() - 1).compare(array[array.length - 1]);
        }
        return largestAndSecond(ans);
    }
}
