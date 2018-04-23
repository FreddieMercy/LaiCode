package LaiOffer.Class27._MostPointsOnALine;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {

    private Double getScope(Point s, Point e) {
        if (e.x == s.x) {
            return null;
        }
        return (((double) e.y - (double) s.y) / ((double) e.x - (double) s.x));
    }

    public int most(Point[] points) {
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
        for (int i = 0; i < points.length; ++i) {
            HashMap<Double, Integer> m = new HashMap<>();
            int samePoint = 0;
            for (int j = 0; j < points.length; ++j) {
                if (i == j) {
                    continue;
                }
                Point start = points[i];
                Point end = points[j];
                if (start.x == end.x && start.y == end.y) {
                    samePoint++;
                    result = Math.max(result, samePoint);
                } else {
                    Double scope = getScope(start, end);

                    Integer s = m.get(scope);
                    if (s == null) {
                        s = 1;
                    }
                    s++;
                    result = Math.max(result, s + samePoint);
                    m.put(scope, s);
                }
            }
        }
        return result;
    }
}