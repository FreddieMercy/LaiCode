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
bool knows(int a, int b);

class Solution {
public:
	int findCelebrity(int n) {
		int tmp = 0;
		for (int i = 1; i < n;++i) {
			if (knows(tmp, i)) {
				tmp = i;
			}
		}
		for (int i = 0; i < n; ++i) {
			if (tmp!=i && (knows(tmp, i)||!knows(i, tmp))) {
				return -1;
			}
		}

		return tmp;
	}
};