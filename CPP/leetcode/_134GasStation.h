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
	int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
		if (gas.size() != cost.size())
		{
			return -1;
		}
		int g = 0, c = 0, tg = 0, tc = 0, begin = 0;
		for (int i = 0; i < gas.size(); ++i)
		{
			g += gas[i];
			c += cost[i];

			if (g < c)
			{
				begin = i + 1;
				tg += g;
				tc += c;
				g = 0;
				c = 0;
			}
		}

		if (g + tg < c + tc)
		{
			return -1;
		}

		return begin;
	}
};
