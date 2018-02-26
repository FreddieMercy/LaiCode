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

using namespace std;

class Solution {
public:
	vector<int> nextGreaterElements(vector<int>& nums) {
		vector<int> retVal;
		for (size_t i = 0; i < nums.size(); ++i)
		{
			bool found = false;
			for (size_t j = i; j < nums.size(); ++j)
			{
				if (nums[j] > nums[i])
				{
					retVal.push_back(nums[j]);
					found = true;
					break;
				}
			}

			if (!found)
			{
				for (size_t j = 0; j < i; ++j)
				{
					if (nums[j] > nums[i])
					{
						retVal.push_back(nums[j]);
						found = true;
						break;
					}
				}
			}

			if (!found)
			{
				retVal.push_back(-1);
			}
		}

		return retVal;
	}
};