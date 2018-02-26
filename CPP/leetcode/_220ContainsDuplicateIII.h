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
	bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
		if (k == 0 || nums.size() == 0)
		{
			return false;
		}

		deque<int64_t> q;
		set<int64_t> s;

		for (size_t i = 0; i < nums.size(); ++i)
		{
			if (q.size() > k)
			{
				int64_t tmp = q.front();
				q.pop_front();
				s.erase(tmp);
			}

			auto low = s.lower_bound((int64_t)nums[i] - (int64_t)t);

			if (low == s.end() || *low > (int64_t)nums[i] + (int64_t)t)
			{
				q.push_back(nums[i]);
				s.insert(nums[i]);
			}
			else
			{
				return true;
			}

		}

		return false;
	}
};