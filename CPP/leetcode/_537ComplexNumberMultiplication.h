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
	string complexNumberMultiply(string x, string y) {
		string a = "", b = "", c = "", d = "";
		int m, n, o, p;
		size_t i = 0;

		while (x[i] != '+')
		{
			a += x[i];
			i++;
		}

		i++;

		while (x[i] != 'i')
		{
			b += x[i];
			i++;
		}

		i = 0;

		while (y[i] != '+')
		{
			c += y[i];
			i++;
		}

		i++;

		while (y[i] != 'i')
		{
			d += y[i];
			i++;
		}

		m = stoi(a, nullptr, 0);
		n = stoi(b, nullptr, 0);
		o = stoi(c, nullptr, 0);
		p = stoi(d, nullptr, 0);

		return to_string(m*o - (n*p)) + "+" + to_string((m*p + n*o)) + "i";
	}
};
