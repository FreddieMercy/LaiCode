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
	vector<int> grayCode(int n) {
		vector<int> ans;
		for (int i = 0; i < 1<<n; ++i) {
			int sth = i>>1;
			int sth2 = i^sth;
			ans.push_back(i^i>>1);
		}
		return ans;
	}
};