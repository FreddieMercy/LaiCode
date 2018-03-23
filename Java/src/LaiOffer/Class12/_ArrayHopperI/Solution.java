package LaiOffer.Class12._ArrayHopperI;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean canJump(int[] array) {
        // Write your solution here
        if(array==null){
            return true;
        }
        int [] dp = array;
        int index = 0;
        Deque<Integer> pre = new LinkedList<>();
        while (index<array.length-1){
            if(dp[index] > 0){
                pre.push(index);
                index += array[index];
            }
            else{
                if(pre.isEmpty()){
                    return false;
                }
                dp[index] = array[index];
                index = pre.pop();
                dp[index]--;
                if(dp[index] <0){
                    dp[index]=0;
                }
            }
        }

        return true;
    }
}
