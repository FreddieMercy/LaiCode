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
private:
	int quickSolve(vector<int>& prices) {
		int len = prices.size(), profit = 0;
		for (int i = 1; i < len; i++)
			// as long as there is a price gap, we gain a profit.
			if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
		return profit;
	}

public:
	int maxProfit(int k, vector<int>& prices) {

		if (k >= prices.size() / 2) return quickSolve(prices);

		int cur = 0, next = 1, retVal = 0;
		vector<int> ptr1;
		vector<int> ptr2;

		for (int j = 0; j < k; j++)
		{
			ptr1.push_back(INT_MIN);
			ptr1.push_back(0);
			ptr2.push_back(INT_MIN);
			ptr2.push_back(0);
		}

		vector<vector<int>> ptr;
		ptr.push_back(ptr1);
		ptr.push_back(ptr2);

		for (size_t i = 0; i < prices.size(); ++i)
		{
			for (int j = 0; j < k * 2 - 1; j += 2)
			{
				if (j == 0)
				{
					ptr[next][j] = max(-prices[i], ptr[cur][j]);
				}
				else
				{
					ptr[next][j] = max(ptr[cur][j - 1] - prices[i], ptr[cur][j]);
				}

				ptr[next][j + 1] = max(ptr[cur][j] + prices[i], ptr[cur][j + 1]);

				retVal = max(retVal, ptr[next][j + 1]);
			}

			swap(cur, next);
		}

		return retVal;
	}
};