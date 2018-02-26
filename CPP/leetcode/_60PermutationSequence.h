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
private:
	int factoria(int a)
	{
		int i = 1;

		for (size_t j = 1; j <= a; ++j)
		{
			i *= j;
		}

		return i;
	}
	string toString(int a)
	{
		string s = "";

		if (a <= 0)
		{
			return "0";
		}

		for (size_t j = 1; j <= a; ++j)
		{
			s += to_string(j);
		}
		return s;
	}
	int findIndex(int a, int b)
	{
		if (a%b == 0 && a != 0)
		{
			return a / b - 1;
		}

		return a / b;
	}
	string removeChar(string s, int index)
	{
		return s.substr(0, index) + s.substr(index + 1, s.length() - index - 1);

	}
	string calculatePer(string input, int j)
	{
		if (input == "")
		{
			return input;
		}
		int b = factoria(input.size()) / input.size();
		int k = j;
		if (k == 0)
		{
			k = input.size()*b;
		}
		int a = findIndex(k, b);
		string c = "";
		if (a >= input.size())
		{
			return "";
		}
		c = input.substr(a, 1);
		string s = removeChar(input, a);
		return c + calculatePer(s, k%b);
	}
public:
	string getPermutation(int n, int k) {
		if (k == 0)
		{
			return "";
		}
		return calculatePer(toString(n), k);
	}
};
