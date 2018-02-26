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
	vector<string> findMissingRanges(vector<int>& nums, int lower, int upper) {
		int i = lower;
		int j = 0;
		vector<string> ans;
		
		while (i <= upper) {
			if (j == nums.size()) {
				if (upper == i) {
					ans.push_back(to_string(i));
				}
				else {
					ans.push_back(to_string(i) + "->" + to_string(upper));
				}
				break;
			}
			if (nums[j] >= i) {
				if (nums[j] > upper) {
					break;
				}
				if (nums[j] == i) {
					if (i > INT_MAX-1) {
						break;
					}
					i++;
				}
				else {
					int tmp = nums[j] - 1;
					if (tmp > upper) {
						tmp = upper;
					}
					if (tmp == i) {
						ans.push_back(to_string(i));
					}
					else {
						ans.push_back(to_string(i)+"->"+to_string(tmp));
					}
					if (tmp > INT_MAX-2) {
						break;
					}
					i = tmp + 2;
				}
			}
			j++;
		}
		return ans;
	}
};