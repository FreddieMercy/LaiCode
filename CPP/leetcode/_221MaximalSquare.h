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
	map<int, map<int, int>>m;

	bool inRange(vector<vector<char>>& matrix, int x, int y)
	{
		if (x >= 0 && x < matrix.size() && y >= 0 && y < matrix[x].size())
		{
			return true;
		}

		return false;
	}

	int cumula(vector<vector<char>>& matrix, int x, int y)
	{
		if (m.find(x) != m.end() && m[x].find(y) != m[x].end())
		{
			return m[x][y];
		}

		if (inRange(matrix, x, y) && matrix[x][y] - '0' > 0)
		{
			int z = min(cumula(matrix, x + 1, y), cumula(matrix, x, y + 1));
			int s = (matrix[x][y] - '0') + min(z, cumula(matrix, x + 1, y + 1));
			m[x][y] = s;
			return s;
		}

		m[x][y] = 0;
		return 0;
	}

public:
	int maximalSquare(vector<vector<char>>& matrix) {
		int _max = 0;

		for (size_t i = 0; i < matrix.size(); ++i)
		{
			for (size_t j = 0; j < matrix[i].size(); ++j)
			{
				_max = max(_max, cumula(matrix, i, j));
			}
		}

		return _max*_max;
	}
};