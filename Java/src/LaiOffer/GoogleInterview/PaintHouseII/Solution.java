package LaiOffer.GoogleInterview.PaintHouseII;

public class Solution {
    private int getHT(int[][][][] dp, int s, int e, int c, boolean isHead) {
        int length = e - s+1;
        int ans = Integer.MAX_VALUE;
/*
        for(int i = 0; i<dp[s][e].length;++i)
            if(i!=c)
                ans=Math.min(ans, dp[s][e][i][(isHead)?1:length]);
            else
                for (int j = (isHead) ? 1 : 0; j < length - ((isHead) ? 0 : 1); ++j)
                    ans = Math.min(ans, dp[s][e][c][j + 1]);
*/
        for(int i = 0; i<dp[s][e].length;++i)
            if(i!=c)
                ans=Math.min(ans, dp[s][e][i][(isHead)?1:length]);

        return ans;
    }

    public int minCostII(int[][] costs) {
        // Write your solution here

        int[][][][] dp = new int[costs.length][costs.length][costs[0].length][costs.length+1];

        for(int end= 0; end < costs.length;++end){
            for(int start = end; start >=0; --start){
                for(int color = 0; color < costs[0].length;++color){

                    int curValue = (dp[start][end][color][0]!=0)?dp[start][end][color][0]:Integer.MAX_VALUE;

                    for(int cur = start; cur<=end;++cur){
                        int pre = (start<=cur-1)?getHT(dp,start,cur-1,color,false):0;
                        int post = (cur+1<=end)?getHT(dp, cur+1, end, color, true):0;

                        if(pre==Integer.MAX_VALUE || post==Integer.MAX_VALUE)
                            continue;
                        int inPlaceValue = pre+costs[cur][color]+post;

                        curValue = Math.min(curValue, inPlaceValue);

                        dp[start][end][color][cur-start+1] = inPlaceValue;
                    }

                    dp[start][end][color][0] = curValue;

                }

            }
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i <costs[0].length; ++i){
            min = Math.min(min, dp[0][costs.length-1][i][0]);
        }
        return min;
    }
}
