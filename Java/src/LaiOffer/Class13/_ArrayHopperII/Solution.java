package LaiOffer.Class13._ArrayHopperII;

public class Solution {
    public int minJump(int[] array) {
        // Write your solution here
        if(array==null||array.length<=1){
            return 0;
        }

        int [] dp = new int[array.length];
        dp[0] = 0;
        for(int i =1; i < dp.length;++i){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < dp.length-1; ++i){
            if(array[i] == 0&&dp[i+1] == Integer.MAX_VALUE){
                return -1;
            }
            for(int j = 1; j <= array[i]; ++j){
                if(i+j<dp.length){
                    dp[i+j] = Math.min(dp[i]+1, dp[i+j]);
                }
            }
        }

        return (dp[dp.length-1]==Integer.MAX_VALUE)?-1:dp[dp.length-1];
    }
}
