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
	vector<vector<int>> fourSum(vector<int>& nums, int target) {
		vector<int> col = nums;
		sort(col.begin(), col.end());
		vector<vector<int>> retV;

		for (size_t x = 0; x < col.size(); ++x)
		{
			if (x > 0 && col[x] == col[x - 1])
			{
				continue;
			}

			for (size_t i = x + 1; i < col.size(); ++i)
			{
				if (i > x + 1 && col[i] == col[i - 1])
				{
					continue;
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
						int s = col[x] + col[i] + col[j] + col[z];

						if (s < target)
						{
							j++;
						}
						else if (s > target)
						{
							z--;
						}
						else
						{
							vector<int> v;
							v.push_back(col[x]);
							v.push_back(col[i]);
							v.push_back(col[j]);
							v.push_back(col[z]);
							retV.push_back(v);
							j++;
						}
					}
				}
			}
		}
		return retV;
	}
};