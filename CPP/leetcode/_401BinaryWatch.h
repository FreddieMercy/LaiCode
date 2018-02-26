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

using namespace std;

class Solution {
public:
	vector<string> readBinaryWatch(int num) {

		vector<string> v;
		for (size_t i = 0; i < 12; ++i)
		{
			for (size_t j = 0; j < 60; ++j)
			{
				bitset<32> min(j);
				bitset<32> hrs(i);

				if (min.count() + hrs.count() == num)
				{
					if (j >= 10)
					{
						v.push_back(to_string(i) + ":" + to_string(j));
					}
					else
					{
						v.push_back(to_string(i) + ":0" + to_string(j));
					}
				}

			}
		}

		return v;
	}
};