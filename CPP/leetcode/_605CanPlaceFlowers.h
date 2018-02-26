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

using namespace std;

class Solution {
public:
	bool canPlaceFlowers(vector<int>& flowerbed, int n) {
		if (n > flowerbed.size())
		{
			return false;
		}

		int tmp = 0;
		int size = 0;

		for (size_t i = 0; i < flowerbed.size(); ++i)
		{
			if (flowerbed[i] == 0)
			{
				tmp++;
			}
			else
			{
				size += tmp / 2;
				tmp = -1;
			}
		}

		tmp++;
		size += tmp / 2;

		if (n <= size)
		{
			return true;
		}

		return false;

	}
};