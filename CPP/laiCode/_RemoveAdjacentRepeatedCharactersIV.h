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
	void removeCurrentDup(string &input, int start) {
		int index = start+1;
		while (index < input.length() && input[index] == input[index - 1]) {
			index++;
		}

		string::iterator it = input.begin() + index;

		while (it<input.end()) {
			*(input.begin() + start) = *it;
			it++;
			start++;
		}

		input = string(input.begin(), input.begin() + start);
	}

public:
	string deDup(string input) {
		// write your solution here

		int index = 1;
		while (index < input.length()) {
			if (input[index] == input[index - 1]) {
				removeCurrentDup(input, index - 1);
				index = 0;
			}
			index++;
		}
		return input;
	}
};
