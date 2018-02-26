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

public:
	vector<vector<int>> threeSum(vector<int>& nums) {

		vector<int> col = nums;
		sort(col.begin(), col.end());
		vector<vector<int>> retV;

		for (size_t i = 0; i < col.size(); ++i)
		{
			if (i > 0 && col[i] == col[i - 1])
			{
				continue;
			}

			if (col[i] > 0)
			{
				break;
			}

			size_t j = i + 1;
			size_t z = col.size() - 1;

			while (j < z)
			{
				while (j > i + 1 && col[j] == col[j - 1])
				{
					j++;
				}

				if (j < z)
				{
					if (col[i] + col[j] > 0)
					{
						break;
					}

					int s = col[i] + col[j] + col[z];

					if (s < 0)
					{
						j++;
					}
					else if (s > 0)
					{
						z--;
					}
					else
					{
						vector<int> v;
						v.push_back(col[i]);
						v.push_back(col[j]);
						v.push_back(col[z]);
						retV.push_back(v);
						j++;
					}
				}
			}
		}

		return retV;
	}
};