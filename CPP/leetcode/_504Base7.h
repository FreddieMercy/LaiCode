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
	string convertToBase7(int num) {

		if (num == 0)
		{
			return "0";
		}

		int input = abs(num);

		int cof = ceil(log(input) / log(7));

		string s = "";

		if (cof >= 0 && input >= pow(7, cof))
		{
			s += to_string((int)(input / pow(7, cof)));
			input %= (int)pow(7, cof);
		}

		cof--;

		while (cof >= 0)
		{
			s += to_string((int)(input / pow(7, cof)));
			input %= (int)pow(7, cof);
			cof--;
		}

		if (num<0)
		{
			s = "-" + s;

		}

		return s;
	}
};