/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug01st2017._130SurroundedRegions;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    private void change(int row, int col, char[][] board){
       /*
        if(row >=0 && row < board.length && col >=0 && col < board[0].length && board[row][col]=='O'){
            board[row][col]='S';
            this.change(row+1, col, board);
            this.change(row-1, col, board);
            this.change(row, col+1, board);
            this.change(row, col-1, board);
        }
        */
        if(board[row][col]=='O'){
            board[row][col]='S';
            if(row>1){
                change(row-1,col, board);
            }
            if(col>1){
                change(row,col-1, board);
            }
            if(row+1<board.length){
                change(row+1,col, board);
            }
            if(col+1<board[row].length){
                change(row,col+1, board);
            }
	}
    }

    public void solve(char[][] board) {
        if(board.length == 0){
            return;
        }
        for(int row = 0; row < board.length;++row)
        {
            for(int col = 0; col < board[0].length;++col)
            {
                if(row > 0 && row < board.length-1 && col > 0 && col < board[0].length-1)
                {
                    continue;
                }
                if(board[row][col]=='O'){
                    
                    this.change(row, col, board);
                }
            }
        }
        for(int row = 0; row < board.length;++row)
        {
            for(int col = 0; col < board[0].length;++col)
            {
                if(board[row][col]=='S')
                {
                    board[row][col]='O';
                }
                else{
                    board[row][col]='X';
                }
            }
        }
    }
}