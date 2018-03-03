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
	string remove(string input, string t) {
		// write your solution here
		set<char> s;
		string::iterator cur = input.begin();
		for (char c : t) {
			s.insert(c);
		}
		for (string::iterator it = input.begin(); it < input.end(); ++it) {
			if (s.find(*it)==s.end()) {
				*cur = *it;
				cur++;
			}
		}
		return string( input.begin(), cur);
	}
};
