package LaiOffer.Class25._MaxWaterTrappedII;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    class Blocks {
        public int height;
        public final int x;
        public final int y;

        public Blocks(int h, int x, int y) {
            height = h;
            this.x = x;
            this.y = y;
        }
    }

    public int maxTrapped(int[][] matrix) {
        // Write your solution here
        if (matrix == null || matrix.length < 3 || matrix[0].length < 3) {
            return 0;
        }
        PriorityQueue<Blocks> pq = new PriorityQueue<>(new Comparator<Blocks>() {
            @Override
            public int compare(Blocks o1, Blocks o2) {
                return o1.height - o2.height;
            }
        });

        int result = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            pq.add(new Blocks(matrix[i][0], i, 0));
            pq.add(new Blocks(matrix[i][matrix[0].length - 1], i, matrix[0].length - 1));
            visited[i][0] = true;
            visited[i][matrix[0].length - 1] = true;
        }

        for (int i = 1; i < matrix[0].length - 1; ++i) {
            pq.add(new Blocks(matrix[0][i], 0, i));
            pq.add(new Blocks(matrix[matrix.length - 1][i], matrix.length - 1, i));
            visited[0][i] = true;
            visited[matrix.length - 1][i] = true;
        }
        while (!pq.isEmpty()) {
            Blocks waterLevel = pq.poll();
            for (Blocks b : finaAllNeighbor(waterLevel, matrix)) {
                if (!visited[b.x][b.y]) {
                    result += Math.max(waterLevel.height - b.height, 0);
                    b.height = Math.max(b.height, waterLevel.height);
                    pq.add(b);
                    visited[b.x][b.y] = true;
                }
            }
        }
        return result;
    }

    private List<Blocks> finaAllNeighbor(Blocks b,  int[][] matrix) {
        List<Blocks> nei = new ArrayList<>();
        if (inRange(b.x + 1, b.y, matrix)) {
            nei.add(new Blocks(matrix[b.x + 1][b.y], b.x + 1, b.y));
        }
        if (inRange(b.x, b.y + 1, matrix) ) {
            nei.add(new Blocks(matrix[b.x][b.y + 1], b.x, b.y + 1));
        }
        if (inRange(b.x - 1, b.y, matrix) ) {
            nei.add(new Blocks(matrix[b.x - 1][b.y], b.x - 1, b.y));
        }
        if (inRange(b.x, b.y - 1, matrix) ) {
            nei.add(new Blocks(matrix[b.x][b.y - 1], b.x, b.y - 1));
        }
        return nei;
    }

    private boolean inRange(int i, int j, int[][] matrix) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return false;
        }
        return true;
    }
}

/*
public class Solution {
    public int maxTrapped(int[][] matrix) {
        // Write your solution here
        if (matrix == null||matrix.length<3||matrix[0].length<3) {
            return 0;
        }
        int ans = 0;
        int[][] dpRow = new int[matrix.length][matrix[0].length];
        int[][] dpCol = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            maxTrappedRows(matrix, dpRow, i);
        }

        for (int i = 0; i < matrix[0].length; ++i) {
            maxTrappedCols(matrix, dpCol, i);
        }

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                //ans+=Math.min(dpRow[i][j], dpCol[i][j]);
                if (matrix[i][j] != dpCol[i][j] || matrix[i][j] != dpRow[i][j]) {
                    if(i==0||j==0||i==matrix.length-1||j==matrix[0].length-1){
                        dfs(matrix, dpRow, dpCol, i, j, 0);
                    }
                    else {
                        if (dpCol[i][j] != dpRow[i][j]) {
                            if (dpCol[i][j] > dpRow[i][j]) {
                                dfs(matrix, dpCol, dpRow, i, j, Integer.MAX_VALUE);
                            } else {
                                dfs(matrix, dpRow, dpCol, i, j, Integer.MAX_VALUE);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                ans += dpRow[i][j] - matrix[i][j];
            }
        }
        return ans;
    }

    private void dfs(int[][] matrix, int[][] dpWrong, int[][] dpRight, int i, int j, int carryIn) {

        int min = Math.max(matrix[i][j], Math.min(carryIn, Math.min(dpRight[i][j], dpWrong[i][j])));

        dpRight[i][j] = min;
        dpWrong[i][j] = min;

        i++;//i+1, j
        if (inRange(i, j, matrix)) {
            if (matrix[i][j] != dpRight[i][j] || matrix[i][j] != dpWrong[i][j]) {
                if (min != dpRight[i][j] || min != dpWrong[i][j]) {
                    dfs(matrix, dpWrong, dpRight, i, j, min);
                }
            }
        }
        i--;
        j++;//i, j+1
        if (inRange(i, j, matrix)) {
            if (matrix[i][j] != dpRight[i][j] || matrix[i][j] != dpWrong[i][j]) {
                if (min != dpRight[i][j] || min != dpWrong[i][j]) {
                    dfs(matrix, dpWrong, dpRight, i, j, min);
                }
            }
        }
        j -= 2;//i, j-1
        if (inRange(i, j, matrix)) {
            if (matrix[i][j] != dpRight[i][j] || matrix[i][j] != dpWrong[i][j]) {
                if (min != dpRight[i][j] || min != dpWrong[i][j]) {
                    dfs(matrix, dpWrong, dpRight, i, j, min);
                }
            }
        }
        j++;
        i--;
        //i-1, j
        if (inRange(i, j, matrix)) {
            if (matrix[i][j] != dpRight[i][j] || matrix[i][j] != dpWrong[i][j]) {
                if (min != dpRight[i][j] || min != dpWrong[i][j]) {
                    dfs(matrix, dpWrong, dpRight, i, j, min);
                }
            }
        }
    }

    private boolean inRange(int i, int j, int[][] matrix) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return false;
        }
        return true;
    }

    private void maxTrappedCols(int[][] matrix, int[][] dp, int L) {
        int highest = 0;

        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i][L] < matrix[highest][L]) {
                dp[i][L] = matrix[highest][L] - matrix[i][L];
            } else {
                highest = i;
            }
        }

        //dp[0][L]+=matrix[0][L];

        int end = highest;
        int i = matrix.length - 1;
        highest = matrix.length - 2;

        while (i >= end) {
            dp[i][L] =0;
            if (matrix[i][L] < matrix[highest][L]) {
                dp[i][L] = matrix[highest][L] - matrix[i][L];
            } else {
                highest = i;
            }
            i--;
        }
        for (int j = 0; j < matrix.length; ++j) {
            dp[j][L] += matrix[j][L];
        }

    }

    private void maxTrappedRows(int[][] matrix, int[][] dp, int INDEX) {
        // Write your solution here

        int highest = 0;

        for (int i = 1; i < matrix[INDEX].length; ++i) {
            if (matrix[INDEX][i] < matrix[INDEX][highest]) {
                dp[INDEX][i] = matrix[INDEX][highest] - matrix[INDEX][i];
            } else {
                highest = i;
            }
        }
        //dp[0][INDEX]+=matrix[0][INDEX];
        int end = highest;
        int i = matrix[INDEX].length - 1;
        highest = matrix[INDEX].length - 2;

        while (i >= end) {
            dp[INDEX][i] =0;
            if (matrix[INDEX][i] < matrix[INDEX][highest]) {
                dp[INDEX][i] = matrix[INDEX][highest] - matrix[INDEX][i];
            } else {
                highest = i;
            }
            i--;
        }

        for (int j = 0; j < matrix[INDEX].length; ++j) {
            dp[INDEX][j] += matrix[INDEX][j];
        }
    }
}

*/