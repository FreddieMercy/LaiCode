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
	int findShortestSubArray(vector<int>& nums) {
		map<int, int> m;
		int v = INT_MIN;
		vector<int> n;
		for (int i : nums) {
			if (m.find(i) == m.end()) {
				m[i] = 1;
			}
			else
			{
				m[i]++;
			}

			if (m[i] > v) {
				v = m[i];
				n.clear();
				n.push_back(i);
			}

			else if (m[i] == v) {
				n.push_back(i);
			}
		}

		int ans = nums.size();

		vector<int> tmp = nums;
		reverse(tmp.begin(), tmp.end());

		while (!n.empty()) {
			ans = min(ans, (int)(tmp.size() - (find(tmp.begin(), tmp.end(), n[0]) - tmp.begin()) - (find(nums.begin(), nums.end(), n[0])-nums.begin())));
			n.erase(n.begin());
		}

		return ans;
	}
};