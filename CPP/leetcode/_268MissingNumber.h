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
	int missingNumber(vector<int>& nums) {
		size_t i = 0;
		vector<int> num = nums;

		sort(num.begin(), num.end());

		for (int n : num)
		{
			if (i != n)
			{
				return i;
			}
			i++;
		}

		return nums.size();
	}
};
