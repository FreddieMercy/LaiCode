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

using namespace std;

class Solution {
private:
	bool checkInBoard(vector<vector<char>>& board, int x, int y)
	{
		if (x >= 0 && x < board.size() && y >= 0 && y < board[0].size())
		{
			return true;
		}

		return false;
	}

	void revel(vector<vector<char>>& board, int x, int y, bool click = false)
	{
		if (checkInBoard(board, x, y))
		{
			if (board[x][y] == 'M' && click)
			{
				board[x][y] = 'X';
				return;
			}

			if (board[x][y] == 'E')
			{
				int num = 0;
				if (checkInBoard(board, x + 1, y + 1) && board[x + 1][y + 1] == 'M')
				{
					num++;
				}
				if (checkInBoard(board, x - 1, y + 1) && board[x - 1][y + 1] == 'M')
				{
					num++;
				}

				if (checkInBoard(board, x + 1, y) && board[x + 1][y] == 'M')
				{
					num++;
				}
				if (checkInBoard(board, x - 1, y) && board[x - 1][y] == 'M')
				{
					num++;
				}

				if (checkInBoard(board, x, y + 1) && board[x][y + 1] == 'M')
				{
					num++;
				}
				if (checkInBoard(board, x - 1, y - 1) && board[x - 1][y - 1] == 'M')
				{
					num++;
				}
				if (checkInBoard(board, x + 1, y - 1) && board[x + 1][y - 1] == 'M')
				{
					num++;
				}
				if (checkInBoard(board, x, y - 1) && board[x][y - 1] == 'M')
				{
					num++;
				}

				if (num > 0)
				{
					board[x][y] = '0' + num;
				}
				else
				{
					board[x][y] = 'B';

					revel(board, x + 1, y + 1);
					revel(board, x - 1, y + 1);
					revel(board, x + 1, y);
					revel(board, x - 1, y);
					revel(board, x, y + 1);
					revel(board, x - 1, y - 1);
					revel(board, x + 1, y - 1);
					revel(board, x, y - 1);
				}
				return;
			}
		}
	}

public:
	vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {

		revel(board, click[0], click[1], true);
		return board;
	}
};