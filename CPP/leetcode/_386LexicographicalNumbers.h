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

class Solution {//https://leetcode.com/problems/lexicographical-numbers/#/solutions
public:
	vector<int> lexicalOrder(int n) {
		vector<int> res(n);
		int cur = 1;
		for (int i = 0; i < n; i++) {
			res[i] = cur;
			if (cur * 10 <= n) {
				cur *= 10;
			}
			else {
				if (cur >= n)
					cur /= 10;
				cur += 1;
				while (cur % 10 == 0)
					cur /= 10;
			}
		}
		return res;
	}
};

/*
class Solution {
public:
	vector<int> lexicalOrder(int n) {
		vector<int> t;

		int i = 0;
		int x = i;
		int y = 1;

		while (t.size() < n)
		{
			while ((i + y*pow(10, x)) <= n)
			{
				t.push_back(i + y*pow(10, x));

				if (i + y*pow(10, x) + 1 < (y + 1)*pow(10, x) && i + y*pow(10, x) + 1 <= n)
				{
					i++;
				}
				else
				{
					i = 0;
					x++;
				}
			}

			y++;
			x = 0;
		}

		return t;

	}
};
*/