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
	int findContentChildren(vector<int>& g, vector<int>& s) {
		int ans = 0;

		sort(g.begin(), g.end());
		sort(s.begin(), s.end());

		int i = 0, j = 0;

		while (i < g.size() && j < s.size()) {
			if (g[i] <= s[j]) {
				ans++;
				i++;
				j++;
			}
			else {
				j++;
			}
		}

		return ans;
	}
};