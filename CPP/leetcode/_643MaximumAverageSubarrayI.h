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
#include "float.h"

using namespace std;

class Solution {
public:
	double findMaxAverage(vector<int>& nums, int k) {
		if (k <= 0 || nums.size() == 0) {
			return 0;
		}
		if (k >= nums.size()) {
			return sum(nums);
		}
		vector<double> sum(nums.size());
		sum[0] = nums[0];
		for (int i = 1; i < sum.size(); ++i) {
			sum[i] = sum[i - 1] + nums[i];
		}

		double ans = sum[k - 1] / k;

		for (int i = 0; i < sum.size() - k; ++i) {
			ans = max(ans, (sum[i + k] - sum[i]) / k);
		}
		return ans;
	}
private:
	double sum(vector<int> a) {
		double ans = 0;
		for (int b : a) {
			ans += b;
		}
		return ans / a.size();
	}
};
//
//class Solution {
//public:
//	double findMaxAverage(vector<int>& nums, int k) {
//		if (k >= nums.size()) {
//			return sum(nums);
//		}
//		double ans = -100000000000;
//		for (int i = 0; i <= nums.size() - k; ++i) {
//			ans = max(ans, sum(vector<int>(nums.begin()+i, nums.begin()+i+k)));
//		}
//
//		return ans;
//	}
//private:
//	double sum(vector<int> a) {
//		double ans = 0;
//		for (int b : a) {
//			ans += b;
//		}
//		return ans/a.size();
//	}
//};