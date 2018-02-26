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
//
//class Solution {
//public:
//	bool containsNearbyDuplicate(vector<int>& nums, int k) {
//
//		if (k==0 || nums.size()==0)
//		{
//			return false;
//		}
//
//		for (size_t i = 0; i < nums.size() - 1; ++i)
//		{
//			for (size_t j = i + 1; j < i + k + 1; ++j)
//			{
//				if (j >= nums.size())
//				{
//					break;
//				}
//
//				if (nums[i] == nums[j])
//				{
//					return true;
//				}
//			}
//		}
//
//		return false;
//	}
//};

class Solution {
public:
	bool containsNearbyDuplicate(vector<int>& nums, int k) {

		if (k == 0 || nums.size() == 0)
		{
			return false;
		}

		map<int, int> m;

		for (size_t i = 0; i < nums.size(); ++i)
		{
			if (m.find(nums[i]) == m.end() || m[nums[i]] + k < i)
			{
				m[nums[i]] = i;
			}
			else
			{
				return true;
			}
		}

		return false;
	}
};