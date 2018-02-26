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

using namespace std;

class Solution {
public:
	int findPoisonedDuration(vector<int>& timeSeries, int duration) {

		if (duration <= 0 | timeSeries.size() == 0)
		{
			return 0;
		}

		if (timeSeries.size() == 1)
		{
			return duration;
		}

		int total = duration;

		for (size_t i = 1; i < timeSeries.size(); ++i)
		{
			if (timeSeries[i] - timeSeries[i - 1] >= duration)
			{
				total += duration;
			}
			else
			{
				total += timeSeries[i] - timeSeries[i - 1];
			}
		}

		return total;
	}
};