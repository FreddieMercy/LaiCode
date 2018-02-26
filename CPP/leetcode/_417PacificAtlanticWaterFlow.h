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

using namespace std;

class Solution {
private:
	class MyClass
	{
	public:

		MyClass(vector<vector<int>> matrix) { _matrix = matrix; }

		int isPacific(int r, int c)
		{
			if (m[r][c].c == -1)
			{
				return m[r][c].b;
			}

			if (m[r][c].c == 0)
			{
				setUpLoc(r, c);
			}

			if (m[r][c].b != 0)
			{
				m[r][c].c = 1;
				return m[r][c].b;
			}

			bool x = r + 1 < _matrix.size() && _matrix[r + 1][c] <= _matrix[r][c];
			bool y = c + 1 < _matrix[r].size() && _matrix[r][c + 1] <= _matrix[r][c];
			bool z = r - 1 >= 0 && _matrix[r - 1][c] <= _matrix[r][c];
			bool e = c - 1 >= 0 && _matrix[r][c - 1] <= _matrix[r][c];

			m[r][c].c = -1;

			if ((x &&  isPacific(r + 1, c) == 1) ||
				(y &&  isPacific(r, c + 1) == 1) ||
				(z &&  isPacific(r - 1, c) == 1) ||
				(e &&  isPacific(r, c - 1) == 1))
			{
				m[r][c].b = 1;
				m[r][c].c = 1;
				return m[r][c].b;
			}

			if ((x &&  m[r + 1][c].c == -1) ||
				(y &&  m[r][c + 1].c == -1) ||
				(z &&  m[r - 1][c].c == -1) ||
				(e &&  m[r][c - 1].c == -1))
			{
				m[r][c].c = 1;
				return m[r][c].b;
			}

			m[r][c].b = -1;
			m[r][c].c = 1;
			return m[r][c].b;
		}
		int isAtlantic(int r, int c)
		{
			if (m[r][c].c == -1)
			{
				return m[r][c].a;
			}

			if (m[r][c].c == 0)
			{
				setUpLoc(r, c);
			}

			if (m[r][c].a != 0)
			{
				m[r][c].c = 1;
				return m[r][c].a;
			}

			bool x = r + 1 < _matrix.size() && _matrix[r + 1][c] <= _matrix[r][c];
			bool y = c + 1 < _matrix[r].size() && _matrix[r][c + 1] <= _matrix[r][c];
			bool z = r - 1 >= 0 && _matrix[r - 1][c] <= _matrix[r][c];
			bool e = c - 1 >= 0 && _matrix[r][c - 1] <= _matrix[r][c];

			m[r][c].c = -1;

			if ((x &&  isAtlantic(r + 1, c) == 1) ||
				(y &&  isAtlantic(r, c + 1) == 1) ||
				(z &&  isAtlantic(r - 1, c) == 1) ||
				(e &&  isAtlantic(r, c - 1) == 1))
			{
				m[r][c].a = 1;
				m[r][c].c = 1;
				return m[r][c].a;
			}

			if ((x &&  m[r + 1][c].c == -1) ||
				(y &&  m[r][c + 1].c == -1) ||
				(z &&  m[r - 1][c].c == -1) ||
				(e &&  m[r][c - 1].c == -1))
			{
				m[r][c].c = 1;
				return m[r][c].a;
			}

			m[r][c].a = -1;
			m[r][c].c = 1;
			return m[r][c].a;
		}

	private:
		struct foo {
			foo() : a(0), b(0), c(0) {}
			int a;
			int b;
			int c;
		};
		map<int, map<int, foo>> m;
		vector<vector<int>> _matrix;
		void setUpLoc(int r, int c)
		{
			m[r][c].c = 1;

			if (r == 0 | c == 0)
			{
				m[r][c].b = 1;
			}

			if (r == _matrix.size() - 1 | c == _matrix[r].size() - 1)
			{
				m[r][c].a = 1;
			}

		}
	};

public:
	vector<pair<int, int>> pacificAtlantic(vector<vector<int>>& matrix) {

		vector<pair<int, int>> ret;
		MyClass *x = new MyClass(matrix);

		for (size_t i = 0; i < matrix.size(); ++i)
		{
			for (size_t j = 0; j < matrix[i].size(); ++j)
			{
				if (x->isAtlantic(i, j) == 1 && x->isPacific(i, j) == 1)
				{
					pair<int, int> tmp;
					tmp.first = i;
					tmp.second = j;
					ret.push_back(tmp);
				}
			}
		}

		return ret;
	}
};