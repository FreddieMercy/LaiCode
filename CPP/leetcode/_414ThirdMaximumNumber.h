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
	int thirdMax(vector<int>& nums) {
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
			return max(nums[0], nums[1]);
		}

		vector<int> v = nums;
		sort(v.begin(), v.end());
		v.erase(unique(v.begin(), v.end()), v.end());

		if (v.size() >= 3)
		{
			return v[v.size() - 3];
		}

		return v[v.size() - 1];
	}
};
