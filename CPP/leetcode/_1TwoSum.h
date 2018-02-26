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
	vector<int> twoSum(vector<int>& nums, int target) {
		map<int, int> m;

		for (size_t i = 0; i < nums.size(); ++i)
		{
			if (m.find(nums[i]) == m.end()) {
				// not found
				m[target - nums[i]] = i;
			}
			else {
				// found
				vector<int> tmp;

				tmp.push_back(m[nums[i]]);
				tmp.push_back(i);

				return tmp;
			}
		}
	}
};
