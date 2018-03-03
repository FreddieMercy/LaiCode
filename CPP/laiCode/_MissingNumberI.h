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
	int missing(vector<int> array) {
		int ruler = 0;
		for (int i = 1; i <= array.size() + 1; ++i) {
			ruler ^= i;
		}
		for (int i : array) {
			ruler ^= i;
		}

		return ruler;
	}
};
