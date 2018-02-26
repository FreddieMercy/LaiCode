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
	//private:
	//	int divid(int a, int x)
	//	{
	//		int c = abs(a);
	//		int b = abs(x);
	//		int i = 0;
	//		while (c > 0)
	//		{
	//			c -= b;
	//			i++;
	//		}
	//
	//		if (a>0 && x<0 || a< 0 && x > 0)
	//		{
	//			return -i;
	//		}
	//
	//		return i;
	//	}

public:
	vector<int> productExceptSelf(vector<int>& nums) {
		vector<int> v, m;
		int product = 1;
		map<int, int> table;

		for (int i = nums.size() - 1; i >= 0; --i)
		{
			table[i] = product;

			if (nums[i] == 0)
			{
				m.push_back(i);
				if (m.size() >= 2)
				{
					break;
				}
				continue;
			}

			product *= nums[i];
		}

		switch (m.size())
		{
		case 0:
			product = 1;
			for (size_t i = 0; i < nums.size(); ++i)
			{
				v.push_back(product*table[i]);
				product *= nums[i];
			}
			break;
		case 1:
			for (size_t i = 0; i < nums.size(); ++i)
			{
				if (i == m[0])
				{
					v.push_back(product);
				}
				else
				{
					v.push_back(0);
				}
			}
			break;
		default:
			for (size_t i = 0; i < nums.size(); ++i)
			{
				v.push_back(0);
			}
			break;
		}

		return v;
	}
};
