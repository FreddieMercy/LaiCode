/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.June2017.Jun20th2017._631DesignExcelSumFormula;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Excel {
    Formula[][] Formulas;
    class Formula {
        Formula(HashMap < String, Integer > c, int v) {
            val = v;
            cells = c;
        }
        HashMap < String, Integer > cells;
        int val;
    }
    Stack < int[] > stack = new Stack < > ();
    public Excel(int H, char W) {
        Formulas = new Formula[H][(W - 'A') + 1];
    }

    public int get(int r, char c) {
        if (Formulas[r - 1][c - 'A'] == null)
            return 0;
        return Formulas[r - 1][c - 'A'].val;
    }
    public void set(int r, char c, int v) {
        Formulas[r - 1][c - 'A'] = new Formula(new HashMap < String, Integer > (), v);
        topologicalSort(r - 1, c - 'A');
        execute_stack();
    }

    public int sum(int r, char c, String[] strs) {
        HashMap < String, Integer > cells = convert(strs);
        int summ = calculate_sum(r - 1, c - 'A', cells);
        set(r, c, summ);
        Formulas[r - 1][c - 'A'] = new Formula(cells, summ);
        return summ;
    }

    public void topologicalSort(int r, int c) {
        for (int i = 0; i < Formulas.length; i++)
            for (int j = 0; j < Formulas[0].length; j++)
                if (Formulas[i][j] != null && Formulas[i][j].cells.containsKey("" + (char)('A' + c) + (r + 1))) {
                    topologicalSort(i, j);
                }
        stack.push(new int[] {r,c});
    }

    public void execute_stack() {
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            if (Formulas[top[0]][top[1]].cells.size() > 0)
                calculate_sum(top[0], top[1], Formulas[top[0]][top[1]].cells);
        }
    }

    public HashMap < String, Integer > convert(String[] strs) {
        HashMap < String, Integer > res = new HashMap < > ();
        for (String st: strs) {
            if (st.indexOf(":") < 0)
                res.put(st, res.getOrDefault(st, 0) + 1);
            else {
                String[] cells = st.split(":");
                int si = Integer.parseInt(cells[0].substring(1)), ei = Integer.parseInt(cells[1].substring(1));
                char sj = cells[0].charAt(0), ej = cells[1].charAt(0);
                for (int i = si; i <= ei; i++) {
                    for (char j = sj; j <= ej; j++) {
                        res.put("" + j + i, res.getOrDefault("" + j + i, 0) + 1);
                    }
                }
            }
        }
        return res;
    }

    public int calculate_sum(int r, int c, HashMap < String, Integer > cells) {
        int sum = 0;
        for (String s: cells.keySet()) {
            int x = Integer.parseInt(s.substring(1)) - 1, y = s.charAt(0) - 'A';
            sum += (Formulas[x][y] != null ? Formulas[x][y].val : 0) * cells.get(s);
        }
        Formulas[r][c] = new Formula(cells, sum);
        return sum;
    }
}

/*
class Excel {
    
    private class Cell {
        
        private int value;
        
        private int leftx[];
        
        private int lefty[];
        
        private int rightx[];
        
        private int righty[];
        
        private boolean format;
        
        public Cell() {this(0);}
        
        public Cell(int v) { value = v; format = false;}
        
        public Cell(String[] formats) {
            this();
            setFormat(formats);
        }
        
        public void setFormat(String[] formats) {
            format = true;
            leftx = new int[formats.length];
            rightx = new int[formats.length];
            lefty = new int[formats.length];
            righty = new int[formats.length];
            for (int i = 0; i < formats.length; i++) {
                String str = formats[i];
                if (str.contains(":")) {
                    String[] cs = str.split(":");
                    lefty[i] = cs[0].charAt(0) - 'A';
                    leftx[i] = getR(cs[0]);
                    righty[i] = cs[1].charAt(0) - 'A';
                    rightx[i] = getR(cs[1]);
                } else {
                    lefty[i] = righty[i] = str.charAt(0) - 'A';
                    leftx[i] = rightx[i] = getR(str);
                }
            }
        }
        
        private int getR(String str) {
            int r = 0;
            for (int i = 1; i < str.length(); i++) r = r * 10 + str.charAt(i) - '0';
            return r;
        }
        
        public void setValue(int v) {
            format = false;
            value = v;
        }
        
        public int getValue(Cell[][] map) {
            if (!format) return value;
            int sum = 0;
            for (int z = 0; z < leftx.length; z++) {
                for (int i = leftx[z]; i <= rightx[z]; i++) {
                    for (int j = lefty[z]; j <= righty[z]; j++) {
                        sum += map[i][j] == null ? 0 : map[i][j].getValue(map);
                    }
                }
            }
            return sum;
        }
    }
    
    private Cell[][] map;

    public Excel(int H, char W) {
        map = new Cell[H + 1][W - 'A' + 1];
    }
    
    public void set(int r, char c, int v) {
        if (map[r][c - 'A'] == null) map[r][c - 'A'] = new Cell(v);
        else map[r][c - 'A'].setValue(v);
    }
    
    public int get(int r, char c) {
        return map[r][c - 'A'] == null ? 0 : map[r][c - 'A'].getValue(map);
    }
    
    public int sum(int r, char c, String[] strs) {
        if (map[r][c - 'A'] == null) map[r][c - 'A'] = new Cell(strs);
        else map[r][c - 'A'].setFormat(strs);
        return get(r, c);
    }
}
 */

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */