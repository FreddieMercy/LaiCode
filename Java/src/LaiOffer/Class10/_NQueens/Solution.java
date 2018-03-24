package LaiOffer.Class10._NQueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> nqueens(int n) {
        // Write your solution here.

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfsFindQueenColumnAndDiagnal(n, cur, ans);

        return ans;
    }

    private void dfsFindQueenColumnAndDiagnal(int n, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() >= n) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (!Attackable(i, cur)) {
                cur.add(i);
                dfsFindQueenColumnAndDiagnal(n, cur, ans);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean Attackable(int column, List<Integer> cur) {
        int row = cur.size();
        for (int i = 0; i < row; ++i) {
            if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
                return true;
            }
        }
        return false;
    }
}
