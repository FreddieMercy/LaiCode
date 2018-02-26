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
using namespace std;

class Solution {
public:
	int maxProfit(vector<int> &prices) {
		int ret = 0;
		for (size_t p = 1; p < prices.size(); ++p)
		{
			ret += max(prices[p] - prices[p - 1], 0);
		}
		return ret;
	}
};