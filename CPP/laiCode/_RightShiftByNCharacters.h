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
	string rightShift(string input, int n) {
		// write your solution here
		if (input.length() > 0) {

			reverse(input.begin(), input.begin() + (input.length() - n % input.length()));
			reverse(input.begin() + (input.length() - n % input.length()), input.end());
			reverse(input.begin(), input.end());
		}
		return input;
	}
};
