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

		int *dp = (int *)malloc(sizeof(int) * nums.size() + 1);

		dp[0] = 0;
		dp[1] = nums[0];

		for (size_t i = 2; i < nums.size() + 1; ++i)
		{
			dp[i] = max(nums[i - 1] + dp[i - 2], dp[i - 1]);
		}

		return dp[nums.size()];
	}
};