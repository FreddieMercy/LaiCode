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
	vector<string> summaryRanges(vector<int>& nums) {
		vector<string> strs;

		if (nums.size() == 0)
		{
			return strs;
		}

		int cur = nums[0];
		int ori = cur;

		for (size_t i = 1; i < nums.size(); ++i)
		{
			if (nums[i] != cur + 1)
			{
				if (ori != nums[i - 1])
				{
					strs.push_back(to_string(ori) + "->" + to_string(nums[i - 1]));
				}
				else
				{
					strs.push_back(to_string(ori));
				}
				ori = nums[i];
			}

			cur = nums[i];
		}

		if (ori == nums[nums.size() - 1])
		{
			strs.push_back(to_string(ori));
		}
		else
		{
			strs.push_back(to_string(ori) + "->" + to_string(nums[nums.size() - 1]));
		}

		return strs;
	}
};