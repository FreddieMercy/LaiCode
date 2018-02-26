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
	bool containsDuplicate(vector<int>& nums) {
		if (nums.size() == 0)
		{
			return false;
		}

		map<int, int> m;

		for (size_t i = 0; i < nums.size(); ++i)
		{
			if (m.find(nums[i]) == m.end())
			{
				m[nums[i]] = 0;
			}
			else
			{
				return true;
			}
		}

		return false;
	}
};
