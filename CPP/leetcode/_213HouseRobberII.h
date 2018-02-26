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
	int rob(vector<int>& nums) {

		if (nums.size() == 0)
		{
			return 0;
		}
		if (nums.size() == 1)
		{
			return nums[0];
		}
		if (nums.size() == 2)
		{
			if (nums[0] > nums[1])
			{
				return nums[0];
			}
			else
			{
				return nums[1];
			}
		}

		int *dp1 = (int *)malloc(sizeof(int) * nums.size());
		int *dp2 = (int *)malloc(sizeof(int) * nums.size());

		dp1[0] = nums[0];
		dp1[1] = dp1[0];

		dp2[0] = 0;
		dp2[1] = nums[1];

		for (size_t i = 2; i < nums.size(); ++i)
		{
			if (i < nums.size() - 1)
			{
				dp1[i] = max(nums[i] + dp1[i - 2], dp1[i - 1]);
			}
			else
			{
				dp1[i] = dp1[i - 1];
			}
			
			dp2[i] = max(nums[i] + dp2[i - 2], dp2[i - 1]);
		}

		if (dp1[nums.size() - 1] > dp2[nums.size() - 1])
		{
			return dp1[nums.size() - 1];
		}

		return dp2[nums.size() - 1];
	}
};