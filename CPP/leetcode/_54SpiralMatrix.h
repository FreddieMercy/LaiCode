#include <iostream>
#include <functional>
#include <vector>
#include <queue>
#include <fstream>
#include <string>
#include <bitset>
#include <sstream>

using namespace std;


class Solution {

private:

	vector<int> spiralOrderHelper(vector<vector<int>>& matrix, int j) {
		vector<int> front, end, back, m;

		if (matrix.size() <= j * 2)
		{
			return front;
		}

		for (int i = j; i + j < matrix[j].size(); i++)
		{
			front.push_back(matrix[j][i]);
		}

		for (int i = j; i + j < matrix[matrix.size() - 1 - j].size(); i++)
		{
			end.push_back(matrix[matrix.size() - 1 - j][i]);
		}

		if (matrix.size() <= j * 2 + 1)
		{
			return front;
		}

		for (int i = j + 1; i + j + 1 < matrix.size(); i++)
		{
			if (j + j + 1 != matrix[i].size() && matrix[i].size() >= 2 * j + 1)
			{
				front.push_back(matrix[i][matrix[i].size() - j - 1]);
				back.push_back(matrix[i][j]);
			}
			else if (matrix[i].size() >= 2 * j + 1)
			{
				front.push_back(matrix[i][matrix[i].size() - j - 1]);
			}
		}

		reverse(end.begin(), end.end());
		reverse(back.begin(), back.end());

		for (int i = 0; i < end.size(); i++)
		{
			front.push_back(end[i]);
		}

		for (int i = 0; i < back.size(); i++)
		{
			front.push_back(back[i]);
		}

		m = spiralOrderHelper(matrix, j + 1);

		for (int i = 0; i < m.size(); i++)
		{
			front.push_back(m[i]);
		}

		return front;
	}

public:
	vector<int> spiralOrder(vector<vector<int>>& matrix) {
		return spiralOrderHelper(matrix, 0);
	}
};
