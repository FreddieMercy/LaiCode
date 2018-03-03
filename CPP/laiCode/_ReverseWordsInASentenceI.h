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
	string reverseWords(string input) {
		// write your solution here
		string::iterator it = input.begin();
		string::iterator cur = input.begin();

		while (it < input.end()) {
			if (*it == ' ') {
				reverse(cur, it);
				cur = it + 1;
			}
			it++;
		};
		reverse(cur, it);
		reverse(input.begin(), input.end());
		return input;
	}
};
