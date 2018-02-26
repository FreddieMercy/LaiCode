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
	string fractionToDecimal(int numerator, int denominator) {
		int64_t a = abs(numerator);
		int64_t b = abs(denominator);

		if (a < 0)
		{
			a = INT_MAX;
			a++;
		}

		if (b < 0)
		{
			b = INT_MAX;
			b++;
		}

		string ans = "";

		if (a == 0 || b == 0)
		{
			return "0";
		}

		int64_t c = a / b;
		int64_t d = a%b;

		ans += to_string(c);

		if (d != 0)
		{
			map<pair<int64_t, int64_t>, int> v;
			size_t index = 1;

			ans += ".";
			d *= 10;
			while (d < b)
			{
				d *= 10;
				index++;
				ans += "0";
			}

			c = d / b;
			d %= b;

			while (d != 0 && v.find(pair<int64_t, int64_t>(c, d)) == v.end())
			{
				index = 0;
				ans += to_string(c);
				v[pair<int64_t, int64_t>(c, d)] = ans.size() - 1;
				bool first = true;
				while (d < b)
				{
					d *= 10;
					if (first)
					{
						first = false;
					}
					else
					{
						index++;
						ans += "0";
					}
				}

				c = d / b;
				d %= b;
			}

			if (d == 0)
			{
				ans += to_string(c);
			}
			else
			{
				string x = ans.substr(0, v[pair<int64_t, int64_t>(c, d)] - index);
				string y = ans.substr(v[pair<int64_t, int64_t>(c, d)] - index, ans.size() - v[pair<int64_t, int64_t>(c, d)]);
				ans = x + "(" + y + ")";
			}
		}

		if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0)
		{
			ans = "-" + ans;
		}

		return ans;
	}
};