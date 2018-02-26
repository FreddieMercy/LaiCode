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
	int longestPalindrome(string s) {
		map<char, int> m;
		int result = 0, max = 0;

		for (char c : s)
		{
			if (m.find(c) == m.end())
			{
				m[c] = 1;
			}
			else
			{
				m[c]++;
			}
		}

		for (auto const &it : m)
		{
			if (it.second % 2 == 0)
			{
				result += it.second;
			}
			else
			{
				if (max == 0)
				{
					max = 1;
				}

				max += it.second - 1;
			}
		}

		if (max != 0)
		{
			return result + max;
		}

		return result;
	}
};