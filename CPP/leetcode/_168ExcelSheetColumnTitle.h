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
	string convertToTitle(int n) {

		if (n == 0)
		{
			return "";
		}

		if (n < 27)
		{
			string t = "";
			return t + (char)(64 + n);
		}

		int a = (n - 1) / 26;
		int b = n % 26;

		if (b == 0)
		{
			return convertToTitle(a) + "Z";
		}
		return convertToTitle(a) + (char)(64 + b);
	}
};