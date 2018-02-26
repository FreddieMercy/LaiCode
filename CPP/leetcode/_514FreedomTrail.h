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
	int findRotateSteps(string ring, string key) {
		int size = ring.size();
		int ksize = key.size();
		vector<vector<int>> mp(26);   //Optimazed_1 use vector instead of unordered_map
									  //stored index of each ,pay attention to duplcate characters.
		for (int i = 0;i<size;++i) {
			mp[ring[i] - 'a'].push_back(i);
		}

		vector<int> dp(size, INT_MAX);   //Optimazed_2,use less space 
		dp[0] = 0;

		vector<int> startIndex(1, 0);// starting index

		for (int i = 1;i <= ksize;++i) {
			vector<int> nextDp(size, INT_MAX);
			for (auto it : mp[key[i - 1] - 'a']) {
				for (int j = 0;j<startIndex.size();++j) {
					int minDist = min((startIndex[j] + size - it) % size, (it + size - startIndex[j]) % size) + dp[startIndex[j]];// Look at the above explanation
					nextDp[it] = min(nextDp[it], minDist);
				}
			}
			startIndex = mp[key[i - 1] - 'a'];
			dp = nextDp;
		}

		int res = INT_MAX;
		for (int i = 0;i<size;++i) {
			res = min(res, dp[i]);
		}  // get the smallest value(step)

		return res + ksize;
	}
};
