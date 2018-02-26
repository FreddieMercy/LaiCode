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
	int lengthOfLongestSubstring(string s) {
		map<char, int> m;
		priority_queue<int> q;
		size_t i = 0;
		size_t z = 0;
		for (size_t j = 0; j < s.size(); ++j)
		{
			if (m.find(s[j]) == m.end() || m[s[j]] < z)
			{
				m[s[j]] = j;
				i++;
			}
			else
			{
				q.push(i);
				i = j - m[s[j]];
				z = m[s[j]];
				m[s[j]] = j;
			}

		}

		q.push(i);

		return q.top();
	}
};