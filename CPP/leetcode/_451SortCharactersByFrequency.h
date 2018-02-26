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
	struct Smaller
	{
		constexpr bool operator()(pair<char, int> const & a, pair<char, int> const & b) const noexcept {
			return a.second < b.second;
		}
	};
	priority_queue<pair<char, int>, vector<pair<char, int>>, Smaller> q;
public:
	string frequencySort(string s) {
		map<char, int> m;
		for (char c : s) {
			m[c]++;
		}
		for (map<char, int>::iterator it = m.begin(); it != m.end();++it) {
			q.push(pair<char, int>(it->first, it->second));
		}
		string ans = "";
		while (!q.empty()) {
			pair<char, int> tmp = q.top();
			q.pop();
			for (int i = 0; i < tmp.second; ++i) {
				ans += tmp.first;
			}
		}
		return ans;
	}
};