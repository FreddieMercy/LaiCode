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

class Solution
{
private:

	bool is_number(const string &s)
	{
		for (char c : s)
		{
			if (!isdigit(c))
			{
				return false;
			}
		}

		return true;
	}

	string removeLeadingZero(string input)
	{
		uint64_t i = 0;

		while (input[i] == '0')
		{
			i++;
		}

		string s = input.substr(i, input.length() - i);

		if (s == "")
		{
			return "0";
		}

		return s;
	}

	string add(string a, string b)
	{
		if (!is_number(a) | !is_number(b))
		{
			return "-1";
		}

		uint64_t x = strtoull(a.c_str(), (char **)NULL, 0);
		uint64_t y = strtoull(b.c_str(), (char **)NULL, 0);

		return to_string(x + y);
	}
	bool findFirst(string num, uint64_t aindex = 0)
	{
		if (num.length() < 3)
		{
			return false;
		}

		for (size_t i = 1; i < ((num.size() - aindex) / 2) + 1; ++i)
		{
			for (size_t j = 1; j < ((num.size() - aindex) / 2) + 1; ++j)
			{
				uint64_t tarDur = 0;

				if (num[aindex] == '0' && num.substr(aindex, i) != "0")
				{
					return false;
				}

				if (num[i + aindex] == '0' && num.substr(i + aindex, j) != "0")
				{
					break;
				}

				if (i > j)
				{
					tarDur = i;
				}
				else
				{
					tarDur = j;
				}

				if (num[i + aindex + j] == '0' && num.substr(i + aindex + j, tarDur) != "0")
				{
					continue;
				}

				if (add(num.substr(aindex, i), num.substr(i + aindex, j)) != "-1" && (add(num.substr(aindex, i), num.substr(i + aindex, j)) == num.substr(i + aindex + j, tarDur) || add(num.substr(aindex, i), num.substr(i + aindex, j)) == num.substr(i + aindex + j, tarDur + 1)))
				{
					if ((i + aindex + j + tarDur == num.length() && add(num.substr(aindex, i), num.substr(i + aindex, j)) == num.substr(i + aindex + j, tarDur)) || (i + aindex + j + 1 + tarDur == num.length() && add(num.substr(aindex, i), num.substr(i + aindex, j)) == num.substr(i + aindex + j, tarDur + 1)) || findFirst(num, i + aindex))
					{
						return true;
					}

				}

			}
		}

		return false;
	}
public:
	bool isAdditiveNumber(string num) {

		if (num.length() < 3)
		{
			return false;
		}

		if (removeLeadingZero(num) == "0")
		{
			return true;
		}

		return findFirst(num);
	}
};