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

using namespace std;

class Solution {
public:
	string smallestGoodBase(string n) {
		
		uint64_t _log;
		uint64_t num = (uint64_t)stoll(n, nullptr, 0);
		
		if (n == "3" || bitset<64>(num).count() == log2(num))
		{
			return "2";
		}

		uint64_t sqrt2 = floor(sqrt(num)) + 1;

		for (uint64_t index = ceil(log2(num)) + 1; index >= 3; --index)
		{
			_log = pow(num, 1.0 / (index - 1));

			if (_log < 2)
			{
				_log = 2;
			}

			while (_log <= sqrt2)
			{
				unsigned long long x = 1;

				for (size_t z = 0; z < index; ++z)
				{
					x *= _log;
				}

				unsigned long long y = num*(_log - 1) + 1;

				if (x == y)
				{
					return to_string(_log);
				}
				else if (x > y)
				{
					break;
				}
				else
				{
					_log++;
				}

			}
		}
		return to_string(num - 1);
	}
};

