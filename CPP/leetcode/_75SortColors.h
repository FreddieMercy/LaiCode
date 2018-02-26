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
	void sortColors(vector<int>& nums) {
		map<int, int> m;

		for (int n : nums)
		{
			if (m.find(n) == m.end())
			{
				m[n] = 1;
			}
			else
			{
				m[n]++;
			}
		}

		nums.clear();

		//for (auto const &it:m)
		//{
		for (size_t i = 0; i < m[0]; ++i)
		{
			nums.push_back(0);
		}
		for (size_t i = 0; i < m[1]; ++i)
		{
			nums.push_back(1);
		}
		for (size_t i = 0; i < m[2]; ++i)
		{
			nums.push_back(2);
		}
		//}
	}
};