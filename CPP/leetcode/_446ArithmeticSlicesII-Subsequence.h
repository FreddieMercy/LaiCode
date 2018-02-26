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

class Solution {
public:
	int numberOfArithmeticSlices(vector<int>& A) {
		if (A.size() < 3) {
			return 0;
		}

		int total = 0;
		map<int, vector<int>> table;
		vector<vector<int>> cnt(A.size(), vector<int>(A.size(), 0));

		for (int i = 0; i < A.size(); ++i) {
			table[A[i]].push_back(i);
		}

		for (int k = 1; k < A.size(); ++k)
		{
			for (int j = k - 1; j >= 0; --j)
			{
				long val_i = (long)A[j] * 2 - A[k];
				if (val_i > INT_MAX || val_i < INT_MIN || table.find(val_i) == table.end()) {
					continue;
				}

				for (int i : table[val_i])
				{
					if (i >= j) {
						break;
					}

					cnt[j][k] += cnt[i][j] + 1;
				}
				total += cnt[j][k];
			}
		}
		return total;
	}
};