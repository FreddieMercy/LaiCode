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
private:
	void trimHead(string &input) {
		string::iterator it = input.begin();

		while (it < input.end()) {
			if (*it != ' ') {
				break;
			}
			it++;
		}

		input = string(it, input.end());
	}
	void trimMid(string &input) {
		string::iterator it = input.begin();
		string::iterator cur = input.begin();
		bool oneSps = false;
		while (it < input.end()) {
			if (*it != ' ' || !oneSps) {
				oneSps = !oneSps&&*it == ' ';
				*cur = *it;
				cur++;
			}
	
			it++;
		}
		input = string(input.begin(), cur);
	}
	void trimTail(string &input) {
		input = string(input.begin(), (*(input.end()-1) == ' ')?input.end()-1:input.end());
	}

public:
	string removeSpaces(string input) {

		// write your solution here
		if (input.length() == 0) {
			return input;
		}

		trimHead(input);
		trimMid(input);
		trimTail(input);

		return input;
	}
};