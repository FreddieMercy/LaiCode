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
private:
	int GCD(int u, int v) {
		while (v != 0) {
			int r = u % v;
			u = v;
			v = r;
		}
		return u;
	}
public:
	bool canMeasureWater(int x, int y, int z) {
		return z == 0 || z <= (uint64_t)x + y && z % GCD(x, y) == 0;
	}
};
