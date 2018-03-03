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
#include <string.h>

using namespace std;

class Solution {

public:
	string replace(string input, string s, string t) {
		// write your solution here
		if (input.length() == 0) {
			return input;
		}

		char *ans = (char *)malloc((input.length() / s.length() + 1)*t.length()*sizeof(char));
		string::iterator it = input.begin();
		int cur = 0;

		while (it<input.end()) {

			if (it <= input.end() - s.length() && string(it, it + s.length()) == s) {

				for (char c : t) {
					ans[cur] = c;
					cur++;
				}

				it += s.length();

			}
			else {
				ans[cur] = *it;

				cur++;
				it++;
			}
		}

		ans[cur] = '\0';
		return string(ans);
		
	}
};
