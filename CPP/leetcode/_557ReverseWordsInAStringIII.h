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
	string reverseWords(string s) {
		string tmp = "";
		string ans = "";
		for (string::iterator i = s.begin(); i < s.end(); ++i) {
			if (*i == ' ') {
				reverse(tmp.begin(), tmp.end());
				ans += tmp+" ";
				tmp = "";
			}
			else {
				tmp += *i;
			}
		}
		reverse(tmp.begin(), tmp.end());
		ans += tmp;
		return ans;
	}
};