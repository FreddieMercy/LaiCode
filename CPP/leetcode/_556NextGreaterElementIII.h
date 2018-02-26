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
private:
	int findMin(string s, char c)
	{
		int b = 0;

		for (int i = 0; i <s.size(); ++i)
		{
			if (s[b] > s[i] && s[i] > c)
			{
				b = i;
			}
		}

		if (s[b] > c)
		{
			return b;
		}

		return -1;
	}
public:
	int nextGreaterElement(int n) {
		if (n < 10)
		{
			return -1;
		}

		string s = to_string(n);

		for (int i = s.length() - 2; i >= 0; --i)
		{
			string s1 = s.substr(i + 1, s.length() - i - 1);
			int tmp = findMin(s1, s[i]);

			if (tmp >= 0)
			{
				char c = s1[tmp];
				if (s[i] - '0' < c - '0')
				{
					s[tmp + 1 + i] = s[i];
					s[i] = c;

					try
					{
						string s2 = s.substr(0, i + 1);
						s1 = s.substr(i + 1, s.length() - i - 1);
						sort(s1.begin(), s1.end());
						return stoi(s2 + s1, nullptr, 0);
					}

					catch (exception)
					{
						continue;
					}
				}
			}

		}

		return -1;
	}
};
