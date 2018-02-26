#include <iostream>
#include <functional>
#include <vector>
#include <queue>
#include <fstream>
#include <string>
#include <bitset>
#include <sstream>
#include <climits>
#include <cmath>
#include <map>
#include <utility>
#include <stdint.h>
#include <algorithm>
#include <stack>
#include <set>

using namespace std;

class TicTacToe {
private:
	vector<char> m = { 'X', 'O' };
	vector<vector<char>> board;
	bool check(int row, int col) {
		return checkDL(row, col) || checkDR(row, col) || checkH(row, col) || checkV(row, col);
	}
	bool checkV(int row, int col) {
		for (int i = 0; i < board.size() - 1;++i) {
			if (board[i][col] != board[i + 1][col]) {
				return false;
			}
		}
		return true;
	}
	bool checkH(int row, int col) {
		for (int i = 0; i < board[row].size() - 1;++i) {
			if (board[row][i] != board[row][i + 1]) {
				return false;
			}
		}
		return true;
	}
	bool checkDL(int row, int col) {
		if (row != col) {
			return false;
		}
		for (int i = 0; i < board.size() - 1;++i) {
			if (board[i][i] != board[i + 1][i + 1]||board[i][i]=='\0') {
				return false;
			}
		}
		return true;
	}
	bool checkDR(int row, int col) {
		if (board.size() - 1 - row != col) {
			return false;
		}
		for (int i = 0; i < board.size() - 1;++i) {
			if (board[i][board.size() - 1 - i] != board[i + 1][board.size() - 1 - i - 1] || board[i][board.size() - 1 - i] == '\0') {
				return false;
			}
		}
		return true;
	}
public:
	/** Initialize your data structure here. */
	TicTacToe(int n) {
		vector<char> tmp(n);
		for (int i = 0; i < n;++i) {
			board.push_back(tmp);
		}
	}

	/** Player {player} makes a move at ({row}, {col}).
	@param row The row of the board.
	@param col The column of the board.
	@param player The player, can be either 1 or 2.
	@return The current winning condition, can be either:
	0: No one wins.
	1: Player 1 wins.
	2: Player 2 wins. */
	int move(int row, int col, int player) {
		board[row][col] = m[player - 1];
		if (check(row, col)) {
			return player;
		}
		return 0;
	}
};

/**
* Your TicTacToe object will be instantiated and called as such:
* TicTacToe obj = new TicTacToe(n);
* int param_1 = obj.move(row,col,player);
*/