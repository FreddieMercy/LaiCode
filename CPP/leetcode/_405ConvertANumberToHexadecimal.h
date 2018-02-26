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
	string toHex(int num) {
		if (num == 0) {
			return "0";
		}
		vector<string> hex = { "0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f" };
		uint32_t ans = num;
		int digit = log(ans) / log(16);

		string retv = "";

		while (digit >= 0) {
			int m = 15;
			while (m*pow(16, digit) > ans) {
				m--;
			}
			ans -= m * pow(16, digit);
			retv += hex[m];
			digit--;
		}

		
		return retv;
	}
};