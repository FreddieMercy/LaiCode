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
	void wiggleSort(vector<int>& nums) {
		vector<int> tmp = nums;
		sort(tmp.begin(), tmp.end());
		int i = 0;
		int mid = tmp.size() - tmp.size() / 2;
		for (int j = 0; j < mid;++j) {
			nums[i] = tmp[mid-1-j];
			if (i + 1 < nums.size()) {
				nums[i + 1] = tmp[tmp.size() -1- j];
			}
			i += 2;
		}
	}
};
//class Solution {
//public:
//	void wiggleSort(vector<int>& nums) {
//		for (int i = 0; i < (int)nums.size() - 1; i++) {
//			if (i % 2 == 0) {
//				if (nums[i] > nums[i + 1]) swap(nums[i], nums[i + 1]);
//			}
//			else {
//				if (nums[i] < nums[i + 1]) swap(nums[i], nums[i + 1]);
//			}
//		}
//	}
//};