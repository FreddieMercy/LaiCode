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
	int threeSumClosest(vector<int>& nums, int target) {

		vector<int> col = nums;
		sort(col.begin(), col.end());

		if (nums.size()<3)
		{
			return 0;
		}

		if (nums.size() == 3)
		{
			return nums[0] + nums[1] + nums[2];
		}

		int retV;
		bool first = true;

		for (size_t i = 0; i < col.size(); ++i)
		{
			if (i > 0 && col[i] == col[i - 1])
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
					int s = col[i] + col[j] + col[z];

					if (first || abs(target - retV) > abs(target - s))
					{
						retV = s;
						first = false;
					}

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
						return s;
					}
				}
			}
		}

		if (retV == INT_MIN)
		{
			return nums[0] + nums[1] + nums[2];
		}

		return retV;
	}
};