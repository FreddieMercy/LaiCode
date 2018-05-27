package LaiOffer.Class27._LargestSetOfPointsWithPositiveSlope;

import java.util.*;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public int largest(Point[] points) {

        // Write your solution here.
        if (points == null) {
            return 0;
        }
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x != o2.x) {
                    return o1.x - o2.x;
                }
                return o1.y - o2.y;
            }
        });

        int result = 0;
        int[] dp = new int[points.length];
        for (int i = 0; i <points.length; ++i) {
            for (int j = 0; j < i; ++j) {
                Point start = points[j];
                Point end = points[i];
                if (end.x > start.x && end.y > start.y) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
            result = Math.max(result, dp[i]);
        }
        return (result==1)?0:result;
    }
}