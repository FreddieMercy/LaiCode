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
private:
	int ans = 0;
	void dfs(vector<int> nums, int S, int index, int sum) {
		if (index == nums.size()) {
			if (sum == S) {
				ans++;
			}
		}
		else {
			dfs(nums, S, index + 1, sum + nums[index]);
			dfs(nums, S, index + 1, sum - nums[index]);
		}
	}
public:
	int findTargetSumWays(vector<int>& nums, int S) {
		dfs(nums, S, 0, 0);
		return ans;
	}
};