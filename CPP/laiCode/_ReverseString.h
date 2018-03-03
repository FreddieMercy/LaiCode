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
	string reverse(string input) {
		// write your solution here
		
		for (int i = 0; i < input.length()/2; ++i) {
			swap(input[i], input[input.length()-1-i]);
		}
		return input;
	}
};
