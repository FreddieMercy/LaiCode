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
	bool validUtf8(vector<int>& data) {
		for (size_t i = 0; i < data.size(); ++i)
		{
			int tmp = data[i];
			bitset<8> bits(tmp);

			if (bits[7] == 0)
			{
				continue;
			}
			else if (bits[7] == 1 && bits[6] == 1)
			{
				int count = 7;

				while (bits[count] == 1)
				{
					count--;
				}

				count++;

				int size = 7 - count;

				if (bits[count - 1] != 0 || size >= 4)
				{
					return false;
				}

				while (size>0)
				{
					i++;
					size--;

					bitset<8> t;

					if (i < data.size())
					{
						t = bitset<8>(data[i]);
					}
					else
					{
						return false;
					}

					if (t[7] != 1 || t[6] != 0)
					{
						return false;
					}
				}

			}
			else
			{
				return false;
			}

		}

		return true;
	}
};