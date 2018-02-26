/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.July2017.July29th2017._79WordSearch;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    private char _word[];
    private char _board[][];
    private Map<Integer, Map<Integer, Boolean>> _used = new HashMap<Integer, Map<Integer, Boolean>>();
    private boolean dfs(int row, int col, int index){
        if(index >= _word.length)
        {
            return true;
        }
        if(index <0 || row<0 || row >= _board.length || col >= _board[row].length || col <0||_board[row][col] != _word[index]||(_used.containsKey(row)&&_used.get(row).containsKey(col)&&_used.get(row).get(col))){
            return false;
        }
        if(!_used.containsKey(row))
        {
            _used.put(row, new HashMap<Integer,Boolean>());
        }
        _used.get(row).put(col, Boolean.TRUE);

        if(this.dfs(row+1, col, index+1)||this.dfs(row-1, col, index+1)||this.dfs(row, col-1, index+1)||this.dfs(row, col+1, index+1))
        {
            return true;
        }
        _used.get(row).put(col, Boolean.FALSE);
        return false;
    }
    public boolean exist(char[][] board, String word) {
        if(word.length()<=0)
        {
            return true;
        }
        if(board.length <= 0){
            return false;
        }
        _word = word.toCharArray();
        _board = board;

        for(int row = 0; row < _board.length; ++row)
        {
            for(int col = 0; col < _board[row].length; ++col){
                if(_board[row][col] == _word[0] && this.dfs(row, col, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
}