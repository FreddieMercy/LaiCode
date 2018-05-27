package LaiOffer.Class21._CuttingWoodI;

public class Solution {
    public int minCost(int[] cuts, int length) {
        // Write your solution here
        int[] lengths = new int[cuts.length+2];
        lengths[0] = 0;
        for(int i = 0; i < cuts.length; ++i){
            lengths[i+1] = cuts[i];
        }
        lengths[lengths.length-1] = length;

        int[][] cost = new int[lengths.length][lengths.length];

        for (int end = 1; end <lengths.length; ++end) {
            for (int start = end-1; start >= 0; --start) {
                if (start == end-1) {
                    cost[start][end] = 0;
                } else {
                    cost[start][end] = Integer.MAX_VALUE;
                    for(int mid = start+1; mid < end;++mid){
                        cost[start][end] = Math.min(cost[start][end], cost[start][mid]+cost[mid][end]+lengths[end]-lengths[start]);
                    }
                }
            }
        }

        return cost[0][lengths.length-1];
    }
}